package org.example.logging.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @since 0.0.1
 */
@Configuration
public class LoggingMessagingConfig {


    @Value("${messaging.exchanges.logging.name:example.logging}")
    private String loggingExchangeName;

    /**
     * Create the {@link org.springframework.amqp.core.Exchange}.
     *
     * @return
     * @since 0.0.1
     */
    @Bean
    public TopicExchange loggingExchange() {

        return new TopicExchange(loggingExchangeName);
    }


    /**
     * Create the {@link RabbitMessagingTemplate} to send messages to the fanout exchange.
     *
     * @return
     * @since 0.0.1
     */
    @Bean
    public RabbitMessagingTemplate loggingMessagingTemplate(final ConnectionFactory connectionFactory) {

        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(loggingExchangeName);

        return new RabbitMessagingTemplate(rabbitTemplate);
    }

}
