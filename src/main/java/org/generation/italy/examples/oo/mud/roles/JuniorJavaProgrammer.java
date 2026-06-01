package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Player;
import org.generation.italy.examples.oo.mud.commands.CommandOutcome;

import java.util.List;

public class JuniorJavaProgrammer extends CharacterClass {
    public JuniorJavaProgrammer() {
        super("Programmatore Java Junior",
                "Sa fare miracoli con un tutorial aperto su un secondo schermo.",
                new CharacterStats(7, 1, 3, 2, 5),
                20,
                3);
    }

    @Override
    public List<SpecialAbility> createSpecialAbilities() {
        return List.of(
                new SpecialAbility() {
                    @Override
                    public String getName() {
                        return "Copia e Incolla";
                    }

                    @Override
                    public String getDescription() {
                        return "Riesce improvvisamente a risolvere un problema copiando una soluzione trovata online.";
                    }

                    @Override
                    public CommandOutcome use(GameContext context, String targetName) {
                        context.getPlayer().heal(4);
                        context.getIo().println("Dopo qualche minuto su Stack Overflow, il codice sembra funzionare.");
                        return CommandOutcome.CONTINUE;
                    }
                },
                new SpecialAbility() {
                    @Override
                    public String getName() {
                        return "Debug Estremo";
                    }

                    @Override
                    public String getDescription() {
                        return "Individua qualcosa di strano nell'ambiente circostante.";
                    }

                    @Override
                    public CommandOutcome use(GameContext context, String targetName) {
                        context.getIo().println("Apri i log mentali e noti dettagli sospetti nella stanza.");
                        return CommandOutcome.CONTINUE;
                    }
                }
        );
    }
}
