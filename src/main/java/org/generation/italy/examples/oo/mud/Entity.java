package org.generation.italy.examples.oo.mud;

public class Entity {
    private int maxHp;
    private int currentHp;
    private String name;
    private int level;

    public Entity(int hp, String name, int level) {
        this.maxHp = hp;
        this.currentHp = hp;
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = Math.max(0, currentHp);
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public String getHpBar() {
        int filled = (int) ((double) currentHp / maxHp * 10);
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < 10; i++) {
            bar.append(i < filled ? "█" : "░");
        }
        bar.append("] ").append(currentHp).append("/").append(maxHp);
        return bar.toString();
    }
}