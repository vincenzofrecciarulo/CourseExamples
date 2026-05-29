package org.generation.italy.examples.oo.mud;

public class Player extends Entity{
    private int coins = 0;

    public Player(int hp, String name, int level) {
        super(hp, name, level);
    }

    public void heal(int heal){
        setHp(getHp() + heal);
    }

    public void setCoins(int coins){
        this.coins = coins;
    }

    public int getCoins(){
        return coins;
    }
}
