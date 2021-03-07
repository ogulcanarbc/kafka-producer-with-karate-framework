package com.oglcnarbc.kafka.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

/**
 * @author Ogulcan Arabaci
 */
public class CustomJsonDeserializer<T> implements Deserializer<T> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> clazz;

    public CustomJsonDeserializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public T deserialize(String topic, byte[] message) {
        try {
            return this.objectMapper.readValue(message, clazz);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @Override
    public T deserialize(String topic, Headers headers, byte[] data) {
        return null;
    }

    @Override
    public void close() {}
}
