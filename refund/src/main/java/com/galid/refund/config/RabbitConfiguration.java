package com.galid.refund.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    String EX_NAME = "amq.topic";
    String Q_NAME = "mail.queue";
    String ROUTING_KEY = "mail.#";

    @Bean
    Queue queue() {
        return new Queue(Q_NAME, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EX_NAME);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
