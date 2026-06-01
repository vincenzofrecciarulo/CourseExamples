package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.Entity;
import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Player;
import org.generation.italy.examples.oo.mud.commands.CommandOutcome;

import java.util.List;

public class Thief extends CharacterClass {
    public Thief() {
        super("Ladro",
                "Rapido, agile e sempre con una mano pronta sulla borsa altrui.",
                new CharacterStats(4, 3, 4, 8, 3),
                22,
                3);
    }

    @Override
    public List<SpecialAbility> createSpecialAbilities() {
        return List.of(new SpecialAbility() {
            @Override
            public String getName() {
                return "Colpo Rapido";
            }

            @Override
            public String getDescription() {
                return "Un attacco veloce che premia la destrezza.";
            }

            @Override
            public CommandOutcome use(GameContext context, String targetName) {
                Player player = context.getPlayer();
                Entity target = context.getCurrentRoom().findEntityByPrefix(targetName);
                if(target == null || target == player){
                    context.getIo().println("Non vedo un bersaglio adatto al colpo rapido.");
                    return CommandOutcome.CONTINUE;
                }
                int damage = 4 + player.getStats().getAgility();
                boolean dead = target.applyDamage(damage);
                context.getIo().println("Colpisci " + target.getName() + " prima che possa reagire.");
                if(dead){
                    context.getIo().println(target.getName() + " crolla a terra.");
                    context.getCurrentRoom().removeEntity(target);
                }
                return CommandOutcome.REFRESH;
            }
        });
    }
}
