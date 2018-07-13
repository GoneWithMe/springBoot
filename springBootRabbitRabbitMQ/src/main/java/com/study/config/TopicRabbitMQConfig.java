package com.study.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitMQConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean
    public Queue messageQueue() {
        return new Queue(TopicRabbitMQConfig.message);
    }

    @Bean
    public Queue messagesQueue() {
        return new Queue(TopicRabbitMQConfig.messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue messageQueue, TopicExchange exchange) {
        return BindingBuilder.bind(messageQueue).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue messagesQueue, TopicExchange exchange) {
        return BindingBuilder.bind(messagesQueue).to(exchange).with("topic.#");
    }
}