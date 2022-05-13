package com.ahxinin.pulsar;

import com.ahxinin.pulsar.annotation.PulsarConsumer;
import com.ahxinin.pulsar.annotation.PulsarProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.AuthenticationFactory;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

/**
 * @author : hexin
 * @description: pulsar client
 * @date : 2022-05-07
 */
@Slf4j
public class PulsarProvider {

    private String serviceUrl;

    private String token;

    private PulsarClient pulsarClient;

    public void init() throws PulsarClientException {
        if (pulsarClient == null){
            log.info("pulsarProvider init, serviceUrl:{}, token:{}", serviceUrl, token);
            pulsarClient = PulsarClient.builder()
                    .serviceUrl(serviceUrl)
                    .authentication(AuthenticationFactory.token(token))
                    .build();
        }
    }

    public void destroy() throws PulsarClientException {
        if (pulsarClient != null){
            log.info("pulsarProvider destroy");
            pulsarClient.close();
        }
    }

    public Producer createProducer(PulsarProducer pulsarProducer) throws PulsarClientException {
        log.info("createProducer topic:{}", pulsarProducer.topic());
        return pulsarClient.newProducer()
                .topic(pulsarProducer.topic())
                .create();
    }

    public Consumer createConsumer(PulsarConsumer pulsarConsumer) throws PulsarClientException {
        log.info("createConsumer topic:{}", pulsarConsumer.topic());
        return pulsarClient.newConsumer()
                .topic(pulsarConsumer.topic())
                .subscriptionName(pulsarConsumer.subscription())
                .subscribe();
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
