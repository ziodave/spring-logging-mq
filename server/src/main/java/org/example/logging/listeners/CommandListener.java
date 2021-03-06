package org.example.logging.listeners;

import org.example.logging.commands.SayHelloCommand;
import org.example.logging.commands.SayHelloCommandExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * Created by david on 28/7/15.
 */
@Service
public class CommandListener {

    private final SayHelloCommandExecutor commandExecutor;

    private final static Logger logger = LoggerFactory.getLogger(LoggingListener.class);

    @Autowired
    public CommandListener(final SayHelloCommandExecutor commandExecutor) {

        this.commandExecutor = commandExecutor;
    }

    @RabbitListener(queues = "#{commandQueue.name}")
    public void onCommandMessage(final Message<SayHelloCommand> message) {

        commandExecutor.execute(message.getPayload());
    }

}
