package org.generation.italy.examples.oo.mud;

public class Entity {
    private String name;
    private Race race;
    private String gender;
    private int currentHp;
    private int level;
    private DndClass dndClass;
    private Weapon equippedWeapon;


    public Entity(int currentHp, String name, int level, Race race, String gender, DndClass dndClass, Weapon equippedWeapon) {
        this.currentHp = currentHp;
        this.name = name;
        this.level = level;
        this.race = race;
        this.gender = gender;
        this.dndClass = dndClass;
        this.equippedWeapon = equippedWeapon;
    }

    public Entity(int currentHp, String name, int level, Race race, String gender){
        this(currentHp, name, level, race, gender, null, null);
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public String getGender() {
        return gender;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getLevel() {
        return level;
    }

    public DndClass getDndClass() {
        return dndClass;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void takeDamage(int damage){
        currentHp = Math.max(0, currentHp - damage);
    }
}
