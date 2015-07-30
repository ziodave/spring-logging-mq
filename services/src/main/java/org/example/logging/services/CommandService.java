package org.example.logging.services;

import org.example.logging.commands.Command;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by david on 28/7/15.
 */
@Service
public class CommandService {

    private final RabbitMessagingTemplate commandMessagingTemplate;

    @Autowired
    public CommandService(@Qualifier("commandMessagingTemplate") final RabbitMessagingTemplate commandMessagingTemplate) {

        this.commandMessagingTemplate = commandMessagingTemplate;
    }

    public void send(final Command command) {

        commandMessagingTemplate.send(command.toString(), MessageBuilder.withPayload(command).build());
    }

    public <T> Message<T> sendAndReceive(final Command command) {

        return (Message<T>)commandMessagingTemplate.sendAndReceive(command.toString(), MessageBuilder.withPayload(command).build());
    }

}
