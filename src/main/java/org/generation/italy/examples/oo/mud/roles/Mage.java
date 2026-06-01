package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.Entity;
import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Player;
import org.generation.italy.examples.oo.mud.commands.CommandOutcome;

import java.util.List;

public class Mage extends CharacterClass {
    public Mage() {
        super("Mago",
                "Studioso delle arti arcane e dei problemi improbabili.",
                new CharacterStats(9, 2, 3, 4, 7),
                18,
                3);
    }

    @Override
    public List<SpecialAbility> createSpecialAbilities() {
        return List.of(new SpecialAbility() {
            @Override
            public String getName() {
                return "Palla di Fuoco";
            }

            @Override
            public String getDescription() {
                return "Scaglia una fiamma contro un nemico.";
            }

            @Override
            public CommandOutcome use(GameContext context, String targetName) {
                Player player = context.getPlayer();
                Entity target = context.getCurrentRoom().findEntityByPrefix(targetName);
                if(target == null || target == player){
                    context.getIo().println("Nessun bersaglio per la palla di fuoco.");
                    return CommandOutcome.CONTINUE;
                }
                int damage = 7 + player.getStats().getIntelligence() / 2;
                boolean dead = target.applyDamage(damage);
                context.getIo().println("Una palla di fuoco investe " + target.getName() + ".");
                if(dead){
                    context.getIo().println(target.getName() + " brucia fino a sparire.");
                    context.getCurrentRoom().removeEntity(target);
                }
                return CommandOutcome.REFRESH;
            }
        });
    }
}
