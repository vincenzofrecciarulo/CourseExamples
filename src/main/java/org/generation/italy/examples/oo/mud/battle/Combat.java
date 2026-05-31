package org.generation.italy.examples.oo.mud.battle;

import org.generation.italy.examples.oo.mud.characters.Player;
import org.generation.italy.examples.oo.mud.characters.enemies.Monster;

public class Combat {
    private Player player;
    private Monster monster;


    public Combat(Player player, Monster monster){
        this.player = player;
        this.monster = monster;
    }

    public Player getPlayer() {
        return player;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean initiative(){
        int totP1 = (int)(Math.random()*20) + 1;
        int totP2 = (int)(Math.random()*20) + 1;

        IO.println("Hai tirato per iniziativa: " + totP1);
        IO.println(monster.getName() + "(" + monster.getRace() + ") " + "ha tirato per iniziativa: " + totP2);

        if(totP1 > totP2){
            IO.println("Inizi per primo!");
            return true;
        }
        IO.println("Il " + monster.getName() + "(" + monster.getRace() + ") " + "attacca per primo!");
        return false;
    }

    public int playerAttack(){
        int playerAttack;

        if(player.getEquippedWeapon() == null){
            playerAttack = player.getDndClass().getBaseStrength();
            monster.takeDamage(playerAttack);
        }else{
            int weaponDmg = player.getEquippedWeapon().getDamage();
            int playerStrength = player.getDndClass().getBaseStrength();
            playerAttack = weaponDmg + playerStrength;
            monster.takeDamage(playerAttack);
        }
        return playerAttack;
    }

    public int monsterAttack(){
        int rawDamage = monster.getAttackDmg();
        player.takeDamage(rawDamage);
        return rawDamage;
    }

    public boolean startCombat(){
        boolean playerFirst = initiative();

        while (player.getCurrentHp() > 0 && monster.getCurrentHp() > 0){
            if(playerFirst){
                int damage = playerAttack();
                IO.println("Hai attaccato " + monster.getName() + " (" + monster.getRace() + ")" + " per " + damage + " danni! Gli rimangono " + monster.getCurrentHp() + " HP");
                if(player.getCurrentHp() > 0 && monster.getCurrentHp() > 0){
                    int monsterDamage = monsterAttack();
                    IO.println(monster.getName() + " (" + monster.getRace() + ")" + " ti attacca per " + monsterDamage + " danni! Ti rimangono " + player.getCurrentHp() + " HP");
                }

            }else{
                int monsterDamage = monsterAttack();
                IO.println(monster.getName() + " (" + monster.getRace() + ")" + " ti attacca per " + monsterDamage + " danni! Ti rimangono " + player.getCurrentHp() + " HP");
                if((player.getCurrentHp() > 0 && monster.getCurrentHp() > 0)){
                    int damage = playerAttack();
                    IO.println("Hai attaccato " + monster.getName() + " (" + monster.getRace() + ")" + " per " + damage + " danni! Gli rimangono " + monster.getCurrentHp() + " HP");
                }
            }
        }
        if(player.getCurrentHp() <= 0){
            IO.println("GAME OVER");
            return false;
        } else{
            IO.println(monster.getName() + " è stato sconfitto!");
            return true;
        }
    }

}
