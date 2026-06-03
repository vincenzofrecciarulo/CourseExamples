package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.GameContext;
import org.generation.italy.examples.oo.mud.world.Player;
import org.generation.italy.examples.oo.mud.roles.AbilityContextFactory;
import org.generation.italy.examples.oo.mud.roles.SpecialAbility;

public class AbilityCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        Player player = context.getPlayer();

        if(args == null || args.isBlank()){
            context.getSession().send("Abilita disponibili:");
            for(SpecialAbility ability : player.getSpecialAbilities()){
                context.getSession().send("- " + ability.getName() + ": " + ability.getDescription());
            }
            return CommandOutcome.CONTINUE;
        }

        return player.useAbility(args.trim(), AbilityContextFactory.from(context));
    }
}
