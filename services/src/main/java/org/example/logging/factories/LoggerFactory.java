package org.example.logging.factories;

import org.example.logging.MessagingLogger;
import org.example.logging.services.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @since 4.2.0
 */
@Service
public class LoggerFactory {

    private static LoggingService loggingService;

    @Autowired
    public LoggerFactory(final LoggingService loggingService) {

        this.loggingService = loggingService;
    }

    public static MessagingLogger getLogger(final Class<?> clazz) {

        return new MessagingLogger(loggingService, clazz);
    }

}
