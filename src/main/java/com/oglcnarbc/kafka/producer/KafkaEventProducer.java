package com.oglcnarbc.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.concurrent.Future;

import static com.oglcnarbc.util.GsonUtil.toJson;

/**
 * @author Ogulcan Arabaci
 */

@Slf4j
public class KafkaEventProducer<K, V> extends KafkaProducer<K, V> {

    private final String topic;
    private Future<RecordMetadata> recordMetadataFuture;
    private ProducerRecord<K, V> producerRecord;

    public KafkaEventProducer(String broker, String topic) {
        super(KafkaProducerConfiguration.getKafkaProperties(broker));
        this.topic = topic;
    }

    public KafkaEventProducer<K, V> sendMessage(V message) {

        return doSend(new ProducerRecord<>(topic, message))
                .onSuccess()
                .closeAndReturnKafkaProducer();

    }

    public KafkaEventProducer<K, V> sendMessage(V message, K messageKey) {
        return doSend(new ProducerRecord<>(topic, messageKey, message))
                .onSuccess()
                .closeAndReturnKafkaProducer();
    }

    public KafkaEventProducer<K, V> sendMessage(V message, Integer partition, K messageKey) {

        return doSend(new ProducerRecord<>(topic, partition, messageKey, message))
                .onSuccess()
                .closeAndReturnKafkaProducer();

    }

    private KafkaEventProducer<K, V> doSend(ProducerRecord<K, V> producerRecord) {
        this.producerRecord = producerRecord;
        this.recordMetadataFuture = send(producerRecord);
        return this;
    }

    private KafkaEventProducer<K, V> onSuccess() {
        try {
            final RecordMetadata metadata = recordMetadataFuture.get();
            log.info(" \n Message is sent to Topic:{}, Partition:{}, Offset:{} \n {} ",
                    topic,
                    metadata.partition(),
                    metadata.offset(),
                    toJson(producerRecord.value()));

        } catch (Exception e) {
            Assertions.fail(" \n Message is don't sent! " + e.getMessage());
        }

        return this;
    }

    private KafkaEventProducer<K, V> closeAndReturnKafkaProducer() {
        close();
        return this;
    }

    private KafkaEventProducer<K, V> closeKafkaProducerWithTimeout(Duration timeout) {
        close(timeout);
        return this;
    }
}