package org.generation.italy.examples.oo.mud;

public class Player {
    private String name = "Alex";
    private int hp = 20;
    private int atk = 10;
    private int def = 8;
    private int exp = 0;
    private int level = 1;


    public void gainExp(int exp){
        this.exp += exp;
        checkLevelUp();
    }
    public void checkLevelUp(){
        if(exp >= level * 20){
            levelUp();
        }
    }
    public void levelUp(){
        level++;
        hp += 2;
        atk += 3;
        def += 2;
    }
    public boolean isAlive(){
        if(hp > 0){
            return true;
        }else{
            return false;
        }
    }
    public void getStats(){
        IO.println("Statistiche del giocatore:");
        IO.println("HP: " + hp);
        IO.println("ATK: " + atk);
        IO.println("DEF: " + def);
        IO.println("LIVELLO: " + level);
    }
    public void takeDamage(int damage){
        if(this.def < damage){
           hp -= damage - this.def;
        }else {
            hp--;
        }
    }
}
