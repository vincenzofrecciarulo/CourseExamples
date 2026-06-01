package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Player;
import org.generation.italy.examples.oo.mud.roles.SpecialAbility;

public class CharacterSheetCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        Player player = context.getPlayer();
        context.getIo().println("Nome: " + player.getName());
        context.getIo().println("Classe: " + player.getCharacterClass().getName());
        context.getIo().println("Descrizione: " + player.getCharacterClass().getDescription());
        context.getIo().println("PF: " + player.getHp() + "/" + player.getMaxHitPoints());
        context.getIo().println("Statistiche: " + player.getStats());
        context.getIo().println("Abilita:");
        for(SpecialAbility ability : player.getSpecialAbilities()){
            context.getIo().println("- " + ability.getName());
        }
        return CommandOutcome.CONTINUE;
    }
}
