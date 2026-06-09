package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.GameContext;

public class EquipCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if(args.isEmpty()){
            context.getSession().send("Equipaggia cosa?");
        } else {
            boolean ok = context.getPlayer().equipByPrefix(args);
            if(ok){
                context.getSession().send("Equipaggiato!");
            } else {
                context.getSession().send("Non trovato nell'inventario: " + args);
            }
        }
        return CommandOutcome.CONTINUE;
    }
}
