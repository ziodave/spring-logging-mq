package org.example.logging.commands;

import org.springframework.stereotype.Service;

/**
 * Created by david on 28/7/15.
 */
@Service
public class SayHelloCommandExecutor implements CommandExecutor<SayHelloCommand, Void> {

    public Void execute(SayHelloCommand command) {

        System.out.println("Hello " + command.getMessage());

        return null;
    }
}
