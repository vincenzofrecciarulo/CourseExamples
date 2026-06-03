package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.world.Entity;
import org.generation.italy.examples.oo.mud.world.Player;
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
            public CommandOutcome use(AbilityContext context, String targetName) {
                Player player = context.getPlayer();
                Entity target = context.resolveTarget(targetName);
                if(target == null || target == player){
                    context.getSession().send("Nessun bersaglio per la palla di fuoco.");
                    return CommandOutcome.CONTINUE;
                }
                int damage = 7 + player.getStats().getIntelligence() / 2;
                boolean dead = target.applyDamage(damage);
                context.getSession().send("Una palla di fuoco investe " + target.getName() + ".");
                if(dead){
                    context.getSession().send(target.getName() + " brucia fino a sparire.");
                    context.getCurrentRoom().removeEntity(target);
                }
                return CommandOutcome.REFRESH;
            }
        });
    }
}
