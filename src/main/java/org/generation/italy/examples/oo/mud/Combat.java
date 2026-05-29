package org.generation.italy.examples.oo.mud;

public class Combat {
    private Player player;
    private Monster monster;
    private Npc npc;

    public Combat(Player player, Monster monster,Npc npc){
        this.player = player;
        this.monster = monster;
        this.npc = npc;
    }

    public boolean initiative(){
        int totP1 = (int)(Math.random()*20) + 1;
        int totP2 = (int)(Math.random()*20) + 1;
        if(totP1 > totP2){
            return true;
        }
        return false;
    }

    public void playerAttack(){
        int weaponDmg = player.getEquippedWeapon().getDamage();
        int playerStrength = player.getDndClass().getBaseStrength();
        int playerAttack = weaponDmg + playerStrength;
        monster.takeDamage(playerAttack);
    }

    public void monsterAttack(){
        int rawDamage = monster.getAttackDmg();
        player.takeDamage(rawDamage);
    }


}
