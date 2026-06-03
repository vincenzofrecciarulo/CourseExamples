package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.world.Entity;
import org.generation.italy.examples.oo.mud.world.Player;
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
            public CommandOutcome use(AbilityContext context, String targetName) {
                Player player = context.getPlayer();
                Entity target = context.resolveTarget(targetName);
                if(target == null || target == player){
                    context.getSession().send("Non vedo un bersaglio adatto al colpo rapido.");
                    return CommandOutcome.CONTINUE;
                }
                int damage = 4 + player.getStats().getAgility();
                boolean dead = target.applyDamage(damage);
                context.getSession().send("Colpisci " + target.getName() + " prima che possa reagire.");
                if(dead){
                    context.getSession().send(target.getName() + " crolla a terra.");
                    context.getCurrentRoom().removeEntity(target);
                }
                return CommandOutcome.REFRESH;
            }
        });
    }
}
