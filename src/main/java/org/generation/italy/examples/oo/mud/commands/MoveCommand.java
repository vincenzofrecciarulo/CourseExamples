package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.GameContext;

public class MoveCommand implements Command {
    private final int direction;
    private final String directionName;

    public MoveCommand(int direction, String directionName) {
        this.direction = direction;
        this.directionName = directionName;
    }

    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if(context.moveTo(direction)){
            context.getSession().send("Ti muovi verso " + directionName);
        } else {
            context.getSession().send("Non c'è nulla in quella direzione");
        }
        return CommandOutcome.REFRESH;
    }
}
