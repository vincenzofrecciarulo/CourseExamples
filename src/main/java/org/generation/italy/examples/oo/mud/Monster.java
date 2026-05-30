package org.generation.italy.examples.oo.mud;

public class Monster extends Entity {

    public enum Rarity {
        COMUNE, NON_COMUNE, RARO, LEGGENDARIO
    }

    private int attackPower;
    private int defense;
    private int expReward;
    private int goldReward;
    private Rarity rarity;
    private boolean isAlive;

    public Monster(int hp, String name, int level, int attackPower, int defense, int expReward, int goldReward, Rarity rarity) {
        super(hp, name, level);
        this.attackPower = attackPower;
        this.defense = defense;
        this.expReward = expReward;
        this.goldReward = goldReward;
        this.rarity = rarity;
        this.isAlive = true;
    }

    // Calcola il danno inflitto al giocatore (con variazione casuale ±20%)
    public int attack() {
        double variation = 0.8 + Math.random() * 0.4; // tra 0.8 e 1.2
        return (int) (attackPower * variation);
    }

    // Calcola il danno subito tenendo conto della difesa e aggiorna currentHp
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

    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (Liv.%d) — ATK:%d DEF:%d | Ricompensa: %d EXP, %d oro",
                rarity, getName(), getLevel(), attackPower, defense, expReward, goldReward);
    }

    // ---------------------------------------------------------------
    // Factory: mostri pronti da usare nel World
    // ---------------------------------------------------------------

    public static Monster goblin() {
        return new Monster(20, "Goblin", 1, 5, 1, 10, 3, Rarity.COMUNE);
    }

    public static Monster ragno() {
        return new Monster(15, "Ragno Velenoso", 1, 4, 0, 8, 2, Rarity.COMUNE);
    }

    public static Monster scheletro() {
        return new Monster(30, "Scheletro Guerriero", 3, 8, 3, 25, 8, Rarity.NON_COMUNE);
    }

    public static Monster orco() {
        return new Monster(50, "Orco Berserker", 5, 14, 5, 50, 20, Rarity.NON_COMUNE);
    }

    public static Monster vampiro() {
        return new Monster(70, "Vampiro Antico", 7, 18, 8, 90, 40, Rarity.RARO);
    }

    public static Monster drago() {
        return new Monster(200, "Drago delle Caverne", 10, 30, 15, 300, 150, Rarity.LEGGENDARIO);
    }

    public static Monster arcimago() {
        return new Monster(90, "Archimago Vetharion", 8, 22, 6, 120, 60, Rarity.RARO);
    }

    public static Monster golemDiPietra() {
        return new Monster(80, "Golem di Pietra", 6, 12, 12, 70, 35, Rarity.NON_COMUNE);
    }
}
