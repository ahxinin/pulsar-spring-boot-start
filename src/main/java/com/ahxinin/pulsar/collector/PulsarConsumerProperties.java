package com.ahxinin.pulsar.collector;

import com.ahxinin.pulsar.annotation.PulsarConsumer;
import com.ahxinin.pulsar.consumer.ConsumerMessage;
import lombok.Builder;
import lombok.Data;

/**
 * @author : hexin
 * @description: 消费者属性
 * @date : 2022-05-13
 */
@Data
@Builder
public class PulsarConsumerProperties {

    private PulsarConsumer pulsarConsumer;

    private ConsumerMessage consumerMessage;
}
