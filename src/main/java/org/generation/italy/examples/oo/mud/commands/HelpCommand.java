package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.GameContext;

public class HelpCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        context.getIo().println("""
                === COMANDI ===
                Movimento: n/nord, s/sud, e/est, o/ovest

                Oggetti:
                  p / prendi <oggetto> - Prendi un oggetto
                  d / getta <oggetto>  - Getta un oggetto
                  i / inventario       - Mostra inventario
                  eq / equipaggia <oggetto> - Equipaggia un oggetto
                  scheda / stats       - Mostra scheda personaggio
                  abilita              - Elenca le abilita
                  usa <abilita> [bersaglio] - Usa una abilita

                Interazione:
                  pa / parla <personaggio>  - Parla con un personaggio
                  at / attacca <nemico>     - Attacca un nemico

                Altro:
                  g / guarda - Mostra stanza
                  h / aiuto  - Questo messaggio
                  q / esci   - Esci dal gioco

                NOTA: I nomi di oggetti e personaggi rispondono a prefix matching!
                Es: "p man" per "prendi Mela", "at lup" per "attacca Lupo Solitario"
                """);
        return CommandOutcome.CONTINUE;
    }
}
