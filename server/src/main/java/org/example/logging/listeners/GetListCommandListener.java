package org.example.logging.listeners;

import org.example.logging.commands.GetListCommand;
import org.example.logging.commands.GetListCommandExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by david on 28/7/15.
 */
@Service
public class GetListCommandListener {

    private final GetListCommandExecutor commandExecutor;

    private final static Logger logger = LoggerFactory.getLogger(LoggingListener.class);

    @Autowired
    public GetListCommandListener(final GetListCommandExecutor commandExecutor) {

        this.commandExecutor = commandExecutor;
    }

    @RabbitListener(queues = "#{commandQueue.name}")
    public List<String> onCommandMessage(final Message<GetListCommand> message) {

        return commandExecutor.execute(message.getPayload());
    }

}
