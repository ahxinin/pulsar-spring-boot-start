package com.ahxinin.pulsar.consumer;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;

/**
 * @author : hexin
 * @description: 消费者
 * @date : 2022-05-13
 */
public interface ConsumerMessage {

    void setConsumer(Consumer consumer);

    void receiver(Consumer consumer, Message message);
}
