package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.GameContext;
import org.generation.italy.examples.oo.mud.world.Player;
import org.generation.italy.examples.oo.mud.roles.SpecialAbility;

public class CharacterSheetCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        Player player = context.getPlayer();
        context.getSession().send("Nome: " + player.getName());
        context.getSession().send("Classe: " + player.getCharacterClass().getName());
        context.getSession().send("Descrizione: " + player.getCharacterClass().getDescription());
        context.getSession().send("PF: " + player.getHp() + "/" + player.getMaxHitPoints());
        context.getSession().send("Statistiche: " + player.getStats());
        context.getSession().send("Abilita:");
        for(SpecialAbility ability : player.getSpecialAbilities()){
            context.getSession().send("- " + ability.getName());
        }
        return CommandOutcome.CONTINUE;
    }
}
