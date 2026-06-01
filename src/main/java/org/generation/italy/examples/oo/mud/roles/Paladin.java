package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Player;
import org.generation.italy.examples.oo.mud.commands.CommandOutcome;

import java.util.List;

public class Paladin extends CharacterClass {
    public Paladin() {
        super("Paladino",
                "Un difensore della luce, solido e affidabile.",
                new CharacterStats(4, 6, 6, 3, 6),
                28,
                3);
    }

    @Override
    public List<SpecialAbility> createSpecialAbilities() {
        return List.of(new SpecialAbility() {
            @Override
            public String getName() {
                return "Benedizione";
            }

            @Override
            public String getDescription() {
                return "Cura il paladino grazie alla luce sacra.";
            }

            @Override
            public CommandOutcome use(GameContext context, String targetName) {
                Player player = context.getPlayer();
                player.heal(8 + player.getStats().getWisdom());
                context.getIo().println("Una luce calda ti avvolge. Ti senti più forte.");
                return CommandOutcome.REFRESH;
            }
        });
    }
}
