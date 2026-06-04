package org.generation.italy.examples.oo.mudMio;

import org.generation.italy.examples.oo.mudMio.conversation.*;

public class NPC extends Entity implements Fightable {

    private int attackPower;
    private int defense;
    private int expReward;
    private int goldReward;
    private boolean isAlive;
    private Conversation conversation;

    public NPC(int hp, String name, int level, int attackPower, int defense, int expReward, int goldReward, Conversation conversation) {
        super(hp, name, level);
        this.attackPower = attackPower;
        this.defense = defense;
        this.expReward = expReward;
        this.goldReward = goldReward;
        this.isAlive = true;
        this.conversation = conversation;
    }


    public int attack() {
        double variation = 0.8 + Math.random() * 0.4; // tra 0.8 e 1.2
        return (int) (attackPower * variation);
    }


    public int takeDamage(int incomingDamage) {
        int actualDamage = Math.max(1, incomingDamage - defense);
        setCurrentHp(getCurrentHp() - actualDamage);
        if (getCurrentHp() <= 0) {
            isAlive = false;
        }
        return actualDamage;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public int getExpReward() {
        return expReward;
    }

    public int getGoldReward() {
        return goldReward;
    }



    @Override
    public String toString() {
        return String.format("[%s] %s (Liv.%d) — ATK:%d DEF:%d | Ricompensa: %d EXP, %d oro",
                getClass().getSimpleName(), getName(), getLevel(), attackPower, defense, expReward, goldReward);
    }


    public String getOpening() {
        return conversation.getOpening();
    }

    public String respond(String choice, Player player) {
        return conversation.respond(choice, player);
    }

    public boolean triggersFight(String choice) {
        return conversation.triggersFight(choice);
    }

    public boolean endsConversation(String choice) {
        return conversation.endsConversation(choice);
    }

    public static NPC CiroLaGuardia() {
        return new NPC(25, "Ciro la guardia", 1, 20, 15, 40, 30,
                new CiroConversation());
    }
    public static NPC BardoMalvino() {
        return new NPC(20, "Bardo Malvino",1,20,12,30,100,
                new MalvinoConversation());
    }
    public static NPC TaberniereGrasso() {
        return new NPC(30,"Taberniere Grasso",1,30,15,50,300,
                new TaberniereConversation());
    }

}






