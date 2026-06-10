package org.generation.italy.examples.pokedex;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    private int hp;

    public Pokemon(int id, String name, String type, int hp) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hp = hp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString(){
        return String.format("ID:%d | Name: %s |Type: %s |HP:%d\n",
                id, name, type, hp);
    }
}
