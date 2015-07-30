package org.example.logging.services;

import org.example.logging.commands.GetListCommand;
import org.example.logging.commands.SayHelloCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Generates a sequence of commands.
 *
 * @since 0.0.2
 */
@Service
public class CommandGeneratorService {

    private final CommandService commandService;

    private final Logger logger = LoggerFactory.getLogger(CommandGeneratorService.class);

    @Autowired
    public CommandGeneratorService(final CommandService commandService) {

        this.commandService = commandService;
    }

    @Scheduled(fixedDelay = 5000)
    public void sayHello() {

        commandService.send(new SayHelloCommand("David!"));

        final Message<List<String>> message = commandService.sendAndReceive(new GetListCommand());
        final List<String> strings = message.getPayload();

        logger.info(String.format("Received %d strings", strings.size()));

    }
}
