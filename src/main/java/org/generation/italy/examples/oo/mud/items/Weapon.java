package org.generation.italy.examples.oo.mud.items;

import org.generation.italy.examples.oo.mud.entities.Player;

public class Weapon extends Item {
    private int damage;
    public Weapon(String name,int damage,double value,boolean coursed){
        super(name,value,20,!coursed);
        this.damage=damage;
        this.type='w';
    }
    public int getDamage(){return damage;}
    @Override
    public String use(Player player){
        if(this.isInUse()) return "Arma già equipaggiata";
        int equipped=0;
        for(Item i: player.getInventory()){
            if(i.isInUse()) equipped++;
        }
        if (equipped>=2)    return "Non puoi equipaggiare piu' di 2" +
                                    "armi alla volta.";
        player.addStrength(damage);
        super.use(player);
        return "Hai equipaggiato con successo "+ this.getName();
    }
    @Override
    public String unUse(Player player){
        String msg=this.getName()+" non è in uso";
        if(this.isInUse()){
            player.addStrength(-damage);
            super.unUse(player);
            msg="Non stai piu' usando "+this.getName();
        }
        return msg;
    }

}
