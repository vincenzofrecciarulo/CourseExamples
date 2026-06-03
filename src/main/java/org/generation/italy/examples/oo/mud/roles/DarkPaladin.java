package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.world.Entity;
import org.generation.italy.examples.oo.mud.world.Player;
import org.generation.italy.examples.oo.mud.commands.CommandOutcome;

import java.util.List;

public class DarkPaladin extends CharacterClass {
    public DarkPaladin() {
        super("Paladino Oscuro",
                "Un cavaliere corrotto che usa il potere dell'ombra.",
                new CharacterStats(3, 7, 5, 4, 4),
                26,
                3);
    }

    @Override
    public List<SpecialAbility> createSpecialAbilities() {
        return List.of(new SpecialAbility() {
            @Override
            public String getName() {
                return "Drenaggio Oscuro";
            }

            @Override
            public String getDescription() {
                return "Colpisce un nemico e recupera parte dell'energia sottratta.";
            }

            @Override
            public CommandOutcome use(AbilityContext context, String targetName) {
                Player player = context.getPlayer();
                Entity target = context.resolveTarget(targetName);
                if(target == null || target == player){
                    context.getSession().send("Non vedo un bersaglio valido per il drenaggio.");
                    return CommandOutcome.CONTINUE;
                }
                int damage = 6 + player.getStats().getStrength() / 2;
                boolean dead = target.applyDamage(damage);
                player.heal(3 + player.getStats().getWisdom() / 2);
                context.getSession().send("L'ombra lacera " + target.getName() + " e ne assorbe la forza.");
                if(dead){
                    context.getSession().send(target.getName() + " è caduto nell'oscurità.");
                    context.getCurrentRoom().removeEntity(target);
                }
                return CommandOutcome.REFRESH;
            }
        });
    }
}
