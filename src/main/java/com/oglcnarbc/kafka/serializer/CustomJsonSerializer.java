package com.oglcnarbc.kafka.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;
import java.util.Objects;

/**
 * @author Ogulcan Arabaci
 */
public class CustomJsonSerializer<T> implements Serializer<T> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CustomJsonSerializer() {
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, T data) {

        if (Objects.isNull(data)) {
            return null;
        }

        try {
            return this.objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    @Override
    public void close() {
    }
}
