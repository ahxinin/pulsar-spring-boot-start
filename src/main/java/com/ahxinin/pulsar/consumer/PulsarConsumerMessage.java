package com.ahxinin.pulsar.consumer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.shade.com.google.gson.Gson;
import org.apache.pulsar.shade.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;

/**
 * @author : hexin
 * @description: 消费者抽象
 * @date : 2022-05-13
 */
public abstract class PulsarConsumerMessage<T> implements ConsumerMessage{

    Class _class = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    private Consumer consumer;

    @Override
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void receiver(Consumer consumer, Message message) {
        String content = new String(message.getData(), StandardCharsets.UTF_8);
        Gson gson = new Gson();
        Object object = gson.fromJson(content, _class);
        handel((T) object);
    }

    public abstract void handel(T message);
}
