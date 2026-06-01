package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.Entity;
import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Player;
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
            public CommandOutcome use(GameContext context, String targetName) {
                Player player = context.getPlayer();
                Entity target = context.getCurrentRoom().findEntityByPrefix(targetName);
                if(target == null || target == player){
                    context.getIo().println("Serve un bersaglio per l'ira.");
                    return CommandOutcome.CONTINUE;
                }
                int damage = 8 + player.getStats().getStrength();
                boolean dead = target.applyDamage(damage);
                context.getIo().println("L'ira del barbaro colpisce " + target.getName() + ".");
                if(dead){
                    context.getIo().println(target.getName() + " viene travolto dalla furia.");
                    context.getCurrentRoom().removeEntity(target);
                }
                return CommandOutcome.REFRESH;
            }
        });
    }
}
