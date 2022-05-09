package com.ahxinin.pulsar.create;

import com.ahxinin.pulsar.PulsarProvider;
import com.ahxinin.pulsar.annotation.PulsarProducer;
import com.ahxinin.pulsar.collector.PulsarProducerCollector;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author : hexin
 * @description: 生产者创建
 * @date : 2022-05-09
 */
@Component
@DependsOn({"pulsarAutoConfiguration","pulsarProducerCollector"})
public class PulsarProducerCreate {

    @Resource
    private PulsarProducerCollector collector;

    @Resource
    private PulsarProvider pulsarProvider;

    @PostConstruct
    public void create(){
        collector.getMap().values().forEach(pulsarProducer->{
            try {
                pulsarProvider.createProducer(pulsarProducer);
            } catch (PulsarClientException e) {
                e.printStackTrace();
            }
        });
    }
}
