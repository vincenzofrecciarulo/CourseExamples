package org.generation.italy.examples.oo.mud.entities;

public class Player extends Entity {
    private int coins = 0;

    public Player(int hp, String name, int level) {
        super(hp, name, level);
    }

    public void heal(int heal){
        hp += heal;
    }

    public int getCoins(){
        return coins;
    }

    public boolean depositCoins(int coins){
        if(coins < 0){
            return false;
        }
        this.coins += coins;
        return true;
    }

    public boolean withdrawCoins(int amount){
        if(coins < amount){
            return false;
        }
        coins -= amount;
        return true;
    }

}
