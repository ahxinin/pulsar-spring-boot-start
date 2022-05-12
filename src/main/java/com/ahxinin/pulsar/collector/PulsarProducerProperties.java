package com.ahxinin.pulsar.collector;

import com.ahxinin.pulsar.annotation.PulsarProducer;
import com.ahxinin.pulsar.producer.ProducerMessage;
import lombok.Builder;
import lombok.Data;

/**
 * @author : hexin
 * @description: 生产者属性
 * @date : 2022-05-12
 */
@Data
@Builder
public class PulsarProducerProperties {

    private PulsarProducer pulsarProducer;

    private ProducerMessage producerMessage;
}
