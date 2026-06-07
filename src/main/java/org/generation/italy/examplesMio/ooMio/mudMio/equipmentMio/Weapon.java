package org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio;

public class Weapon extends Item {
    private int damage;

    public Weapon(double weight, int value, String name, int damage){
        super(weight, value, name);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
