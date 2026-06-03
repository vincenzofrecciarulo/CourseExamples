package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Entity {

    private int hp;
    private String name;
    private int level;
    private Inventory inventory;
    private ArrayList<Move> moves;
    private Question question;
    private boolean defeated=false;

    public Entity(int hp, String name, int level, ArrayList<Move> moves, Question question) {
        this.hp = hp;
        this.name = name;
        this.level = level;
        this.moves=moves;
        this.question=question;
    }

    public Entity(int hp, String name, int level, ArrayList<Move> moves) {
        this(hp, name, level, moves, null);
    }

    public boolean hasQuestion(){
        return question != null;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Question getQuestion(){
        return question;
    }

    public boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
