package com.ahxinin.pulsar.producer;

import java.nio.charset.StandardCharsets;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.shade.com.google.gson.Gson;
import org.apache.pulsar.shade.com.google.gson.JsonObject;

/**
 * @author : hexin
 * @description: 生产者抽象
 * @date : 2022-05-12
 */
public class PulsarProducerMessage<T> implements ProducerMessage{

    private Producer producer;

    @Override
    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void send(T message) throws PulsarClientException {
        Gson gson = new Gson();
        String content = gson.toJson(message);
        producer.send(content.getBytes(StandardCharsets.UTF_8));
    }
}
