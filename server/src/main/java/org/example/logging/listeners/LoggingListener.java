package org.example.logging.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Receives logging events.
 *
 * @since 0.0.1
 */
@Service
public class LoggingListener {

    private final static Logger logger = LoggerFactory.getLogger(LoggingListener.class);

    @RabbitListener(queues = "#{loggingQueue.name}")
    public void onLoggingMessage(final Message<String> message) {

        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, Object> entry : message.getHeaders().entrySet())
            sb.append(entry.getKey()).append(" :: ").append(String.valueOf(entry.getValue())).append(" ; ");

        logger.info(String.format("Log received [ message :: %s ][ headers :: %s ]", message.getPayload(), sb.toString()));
    }
}
