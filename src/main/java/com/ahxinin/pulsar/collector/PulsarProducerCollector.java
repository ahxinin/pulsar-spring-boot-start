package com.ahxinin.pulsar.collector;

import com.ahxinin.pulsar.annotation.PulsarProducer;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author : hexin
 * @description: 收集已注册的生产者
 * @date : 2022-05-09
 */
@Configuration
public class PulsarProducerCollector implements BeanPostProcessor {

    private final ConcurrentHashMap<String, PulsarProducer> map = new ConcurrentHashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        Class<?> beanClass = bean.getClass();
        PulsarProducer pulsarProducer = beanClass.getAnnotation(PulsarProducer.class);
        map.put(beanName, pulsarProducer);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    public ConcurrentHashMap<String, PulsarProducer> getMap() {
        return map;
    }
}
