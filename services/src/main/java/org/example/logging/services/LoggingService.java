package org.example.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Send some random logs.
 *
 * @since 0.0.1
 */
@Service
public class LoggingService {

    private final RabbitMessagingTemplate loggingMessagingTemplate;

    public enum Level {
        TRACE, DEBUG, INFO, WARN, ERROR
    }

    private final static Logger logger = LoggerFactory.getLogger(LoggingService.class);

    /**
     * Create an instance of the Logging Service, whose task is to send a log message every second.
     *
     * @param loggingMessagingTemplate
     * @since 0.0.1
     */
    @Autowired
    public LoggingService(@Qualifier("loggingMessagingTemplate") final RabbitMessagingTemplate loggingMessagingTemplate) {

        logger.info("Initializing the Logging Service...");

        this.loggingMessagingTemplate = loggingMessagingTemplate;
    }

    /**
     * Send an info message.
     *
     * @since 0.0.1
     */
    public void info(final String message) {

        logger.info("Sending... " + Level.INFO.name());

        loggingMessagingTemplate.send(Level.INFO.name(), MessageBuilder.withPayload("A test message " + System.nanoTime()).build());
    }
}
