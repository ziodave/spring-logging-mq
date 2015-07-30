package org.example.logging.commands;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 29/7/15.
 */
@Service
public class GetListCommandExecutor implements CommandExecutor<GetListCommand, List<String>> {

    private final List<String> strings;

    public GetListCommandExecutor() {

        strings = new ArrayList<String>(3);
        strings.add("Hello");
        strings.add("World");
        strings.add("!");
    }

    @Override
    public List<String> execute(final GetListCommand command) {

        return strings;
    }

}
