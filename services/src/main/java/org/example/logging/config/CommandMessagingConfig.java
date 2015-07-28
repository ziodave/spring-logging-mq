package org.example.logging.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @since 0.0.2
 */
@Configuration
public class CommandMessagingConfig {

    @Value("${messaging.exchanges.command.name:example.command}")
    private String commandExchangeName;

    /**
     * Create the {@link org.springframework.amqp.core.Exchange}.
     *
     * @return
     * @since 0.0.2
     */
    @Bean
    public TopicExchange commandExchange() {

        return new TopicExchange(commandExchangeName);
    }


    /**
     * Create the {@link RabbitMessagingTemplate} to send messages to the exchange.
     *
     * @return
     * @since 0.0.2
     */
    @Bean
    public RabbitMessagingTemplate commandMessagingTemplate(final ConnectionFactory connectionFactory) {

        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(commandExchangeName);

        return new RabbitMessagingTemplate(rabbitTemplate);
    }

}
