package org.example.logging.commands;

import org.springframework.stereotype.Service;

/**
 * Created by david on 29/7/15.
 */
public interface CommandExecutor<T extends Command, U> {

    <U> U execute(T command);

}
