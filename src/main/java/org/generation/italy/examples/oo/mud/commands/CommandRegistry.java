package org.generation.italy.examples.oo.mud.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandRegistry register(String alias, Command command) {
        commands.put(alias.toLowerCase(), command);
        return this;
    }

    public Command get(String alias) {
        if(alias == null){
            return null;
        }
        return commands.get(alias.toLowerCase());
    }
}
