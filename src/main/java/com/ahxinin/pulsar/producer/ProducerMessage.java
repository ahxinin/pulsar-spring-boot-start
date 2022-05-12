package com.ahxinin.pulsar.producer;

import org.apache.pulsar.client.api.Producer;

/**
 * @author : hexin
 * @description: 生产者处理消息
 * @date : 2022-05-12
 */
public interface ProducerMessage {

    void setProducer(Producer producer);
}
