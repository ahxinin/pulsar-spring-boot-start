package com.ahxinin.pulsar.consumer;

import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.shade.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;

/**
 * @author : hexin
 * @description: 消费者
 * @date : 2022-05-13
 */
public interface ConsumerMessage {

    void setConsumer(Consumer consumer);

    void receiver(Consumer consumer, Message message);
}
