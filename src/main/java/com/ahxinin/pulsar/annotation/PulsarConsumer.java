package com.ahxinin.pulsar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : hexin
 * @description: 消费者注解
 * @date : 2022-05-13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PulsarConsumer {

    String topic() default "";

    String subscription() default "";
}
