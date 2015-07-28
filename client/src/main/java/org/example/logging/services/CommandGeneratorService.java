package org.example.logging.services;

import org.example.logging.commands.SayHelloCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Generates a sequence of commands.
 *
 * @since 0.0.2
 */
@Service
public class CommandGeneratorService {

    private final CommandService commandService;

    @Autowired
    public CommandGeneratorService(final CommandService commandService) {

        this.commandService = commandService;
    }

    @Scheduled(fixedDelay = 5000)
    public void sayHello() {

        commandService.send(new SayHelloCommand("David!"));

    }
}
