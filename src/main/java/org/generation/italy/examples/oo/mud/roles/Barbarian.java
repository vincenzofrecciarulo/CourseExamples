package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.world.Entity;
import org.generation.italy.examples.oo.mud.world.Player;
import org.generation.italy.examples.oo.mud.commands.CommandOutcome;

import java.util.List;

public class Barbarian extends CharacterClass {
    public Barbarian() {
        super("Barbaro",
                "Forza bruta, poca diplomazia e molto rumore.",
                new CharacterStats(2, 9, 8, 3, 2),
                32,
                3);
    }

    @Override
    public List<SpecialAbility> createSpecialAbilities() {
        return List.of(new SpecialAbility() {
            @Override
            public String getName() {
                return "Ira";
            }

            @Override
            public String getDescription() {
                return "Un attacco rabbioso che fa tremare i nemici.";
            }

            @Override
            public CommandOutcome use(AbilityContext context, String targetName) {
                Player player = context.getPlayer();
                Entity target = context.resolveTarget(targetName);
                if(target == null || target == player){
                    context.getSession().send("Serve un bersaglio per l'ira.");
                    return CommandOutcome.CONTINUE;
                }
                int damage = 8 + player.getStats().getStrength();
                boolean dead = target.applyDamage(damage);
                context.getSession().send("L'ira del barbaro colpisce " + target.getName() + ".");
                if(dead){
                    context.getSession().send(target.getName() + " viene travolto dalla furia.");
                    context.getCurrentRoom().removeEntity(target);
                }
                return CommandOutcome.REFRESH;
            }
        });
    }
}
