package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Player;
import org.generation.italy.examples.oo.mud.commands.CommandOutcome;

import java.util.List;

public class Priest extends CharacterClass {
    public Priest() {
        super("Sacerdote",
                "Custode della fede e della guarigione.",
                new CharacterStats(5, 2, 4, 3, 9),
                20,
                3);
    }

    @Override
    public List<SpecialAbility> createSpecialAbilities() {
        return List.of(new SpecialAbility() {
            @Override
            public String getName() {
                return "Guarigione";
            }

            @Override
            public String getDescription() {
                return "Ripristina i punti ferita del sacerdote o di un alleato.";
            }

            @Override
            public CommandOutcome use(GameContext context, String targetName) {
                Player player = context.getPlayer();
                if(targetName == null || targetName.isBlank()){
                    player.heal(10 + player.getStats().getWisdom());
                    context.getIo().println("Reciti una preghiera e le ferite si chiudono.");
                    return CommandOutcome.REFRESH;
                }
                context.getIo().println("Per ora la guarigione funziona solo su te stesso.");
                return CommandOutcome.CONTINUE;
            }
        });
    }
}
