package org.example.logging.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures a queue to receive logging events.
 *
 * @since 0.0.1
 */
@Configuration
@EnableRabbit
public class LoggingReceiverConfig {

    @Autowired
    private TopicExchange loggingExchange;


    /**
     * Create an anonymous queue to bind to the logging fanout.
     *
     * @return
     * @since 0.0.1
     */
    @Bean
    public Queue loggingQueue() {

        return new AnonymousQueue();
    }


    @Bean
    public Binding loggingBinding() {

        return BindingBuilder.bind(loggingQueue()).to(loggingExchange).with("#");
    }

}
