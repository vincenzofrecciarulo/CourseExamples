package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.Entity;
import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Player;
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
            public CommandOutcome use(GameContext context, String targetName) {
                Player player = context.getPlayer();
                Entity target = context.getCurrentRoom().findEntityByPrefix(targetName);
                if(target == null || target == player){
                    context.getIo().println("Non vedo un bersaglio valido per il drenaggio.");
                    return CommandOutcome.CONTINUE;
                }
                int damage = 6 + player.getStats().getStrength() / 2;
                boolean dead = target.applyDamage(damage);
                player.heal(3 + player.getStats().getWisdom() / 2);
                context.getIo().println("L'ombra lacera " + target.getName() + " e ne assorbe la forza.");
                if(dead){
                    context.getIo().println(target.getName() + " è caduto nell'oscurità.");
                    context.getCurrentRoom().removeEntity(target);
                }
                return CommandOutcome.REFRESH;
            }
        });
    }
}
