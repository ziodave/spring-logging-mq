package org.example.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * A log generator.
 *
 * @since 0.0.1
 */
@Service
public class LogGeneratorService {

    private final LoggingService loggingService;

    private final static Logger logger = LoggerFactory.getLogger(LogGeneratorService.class);

    /**
     * Create an instance of the log generator which will send logs at a periodic interval using the {@link LoggingService}.
     *
     * @param loggingService
     * @since 0.0.1
     */
    @Autowired
    public LogGeneratorService(final LoggingService loggingService) {

        this.loggingService = loggingService;
    }


    /**
     * Send a log every 5 seconds.
     *
     * @since 0.0.1
     */
    @Scheduled(fixedRate = 5000)
    public void sendRandomLogs() {

        loggingService.info("Sending a log...");
    }
}
