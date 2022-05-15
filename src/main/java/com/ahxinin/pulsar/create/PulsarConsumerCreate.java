package com.ahxinin.pulsar.create;

import com.ahxinin.pulsar.PulsarProvider;
import com.ahxinin.pulsar.collector.PulsarConsumerCollector;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.pulsar.client.api.Consumer;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author : hexin
 * @description: 消费者创建
 * @date : 2022-05-13
 */
@Component
@DependsOn({"pulsarAutoConfiguration","pulsarConsumerCollector"})
public class PulsarConsumerCreate {

    @Resource
    private PulsarConsumerCollector collector;

    @Resource
    private PulsarProvider provider;

    @PostConstruct
    public void create(){
        collector.getConsumers().values().forEach(properties->{
            try {
                Consumer consumer = provider.createConsumer(properties);
                properties.getConsumerMessage().setConsumer(consumer);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
