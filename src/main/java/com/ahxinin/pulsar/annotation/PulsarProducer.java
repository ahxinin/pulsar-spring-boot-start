package com.ahxinin.pulsar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : hexin
 * @description: 生产者注解
 * @date : 2022-05-08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PulsarProducer {

    /**
     * 订阅主题
     */
    String topic() default "";
}
