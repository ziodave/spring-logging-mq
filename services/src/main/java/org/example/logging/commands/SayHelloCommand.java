package org.example.logging.commands;

/**
 * Created by david on 28/7/15.
 */
public class SayHelloCommand implements Command {

    private String message;

    public SayHelloCommand(final String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
