package org.example.logging.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures a queue to receive commands.
 *
 * @since 0.0.2
 */
@Configuration
@EnableRabbit
public class CommandReceiverConfig {

    @Autowired
    private TopicExchange commandExchange;


    /**
     * Create an anonymous queue to bind to the command exchange.
     *
     * @return
     * @since 0.0.1
     */
    @Bean
    public Queue commandQueue() {

        return new AnonymousQueue();
    }


    @Bean
    public Binding commandBinding() {

        return BindingBuilder.bind(commandQueue()).to(commandExchange).with("#");
    }

}
