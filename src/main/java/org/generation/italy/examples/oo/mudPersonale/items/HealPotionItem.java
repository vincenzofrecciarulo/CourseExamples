package org.generation.italy.examples.oo.mudPersonale.items;

import org.generation.italy.examples.oo.mudPersonale.Helper;
import org.generation.italy.examples.oo.mudPersonale.entities.Player;
import org.generation.italy.examples.oo.mudPersonale.entities.pokemon.PokemonEntity;
import org.generation.italy.examples.oo.mudPersonale.enums.HealPotion;
import org.generation.italy.examples.oo.mudPersonale.enums.Pokemon;

public class HealPotionItem extends Item{
    private final int healAmount;

    public HealPotionItem(HealPotion healPotion) {
        super(healPotion.getWeight(), healPotion.getPrice(), healPotion.getName());
        this.healAmount = healPotion.getHealAmount();
    }

    @Override
    public void interact(Player player){
        if(player.healPokemon(healAmount)){
            player.drop(this);
        }
    }

    public static HealPotionItem getRandomHealPotionItem(){
        int randomNum = Helper.getRandomNumber(HealPotion.values().length);
        HealPotion potion = HealPotion.values()[randomNum];
        return new HealPotionItem(potion);
    }
}
