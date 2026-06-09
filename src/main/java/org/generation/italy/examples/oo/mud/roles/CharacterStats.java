package org.generation.italy.examples.oo.mud.roles;

public class CharacterStats {
    public enum StatCategory {
        VERY_POOR,
        AVERAGE,
        GOOD,
        EXCELLENT
    }

    private final int intelligence;
    private final int strength;
    private final int stamina;
    private final int agility;
    private final int wisdom;

    public CharacterStats(int intelligence, int strength, int stamina, int agility, int wisdom) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.stamina = stamina;
        this.agility = agility;
        this.wisdom = wisdom;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getStamina() {
        return stamina;
    }

    public int getAgility() {
        return agility;
    }

    public int getWisdom() {
        return wisdom;
    }

    public static StatCategory getCategory(int value) {
        if(value < 6){
            return StatCategory.VERY_POOR;
        }
        if(value <= 12){
            return StatCategory.AVERAGE;
        }
        if(value <= 17){
            return StatCategory.GOOD;
        }
        return StatCategory.EXCELLENT;
    }

    public static String getCategoryLabel(int value) {
        return switch(getCategory(value)) {
            case VERY_POOR -> "estremamente scarso";
            case AVERAGE -> "discreto";
            case GOOD -> "buono";
            case EXCELLENT -> "eccellente";
        };
    }

    @Override
    public String toString() {
        return "INT=" + intelligence + " (" + getCategoryLabel(intelligence) + ")" +
                ", FOR=" + strength + " (" + getCategoryLabel(strength) + ")" +
                ", STA=" + stamina + " (" + getCategoryLabel(stamina) + ")" +
                ", AGI=" + agility + " (" + getCategoryLabel(agility) + ")" +
                ", SAG=" + wisdom + " (" + getCategoryLabel(wisdom) + ")";
    }
}
