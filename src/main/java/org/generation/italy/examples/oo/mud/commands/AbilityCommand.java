package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Player;
import org.generation.italy.examples.oo.mud.roles.SpecialAbility;

public class AbilityCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        Player player = context.getPlayer();

        if(args == null || args.isBlank()){
            context.getIo().println("Abilita disponibili:");
            for(SpecialAbility ability : player.getSpecialAbilities()){
                context.getIo().println("- " + ability.getName() + ": " + ability.getDescription());
            }
            return CommandOutcome.CONTINUE;
        }

        return player.useAbility(args.trim(), context);
    }
}
