package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.GameContext;

public class EquipCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if(args.isEmpty()){
            context.getIo().println("Equipaggia cosa?");
        } else {
            boolean ok = context.getPlayer().equipByPrefix(args);
            if(ok){
                context.getIo().println("Equipaggiato!");
            } else {
                context.getIo().println("Non trovato nell'inventario: " + args);
            }
        }
        return CommandOutcome.CONTINUE;
    }
}
