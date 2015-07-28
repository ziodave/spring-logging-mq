package org.example.logging.commands;

import java.io.Serializable;

/**
 * Created by david on 28/7/15.
 */
public class SayHelloCommandExecutor implements Serializable {

    private SayHelloCommand commandBag;

    public SayHelloCommandExecutor(final SayHelloCommand commandBag) {

        this.commandBag = commandBag;
    }

    public void execute() {

        System.out.println("Hello " + commandBag.getMessage());
    }
}
