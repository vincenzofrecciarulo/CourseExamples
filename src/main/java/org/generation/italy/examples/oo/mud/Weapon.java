package org.generation.italy.examples.oo.mud;

public class Weapon extends Item {
    private boolean isWeared;
    private int hp;
    private int power;

    public Weapon(double weight, int value, String name, boolean isWeared, int hp, int power) {
        super(weight, value, name);
        this.isWeared = isWeared;
        this.hp = hp;
        this.power = power;
    }

    public boolean isWeared()  { return isWeared; }
    public int getPower()    { return power; }
    public void wear()         { this.isWeared = true; }
    public void remove()       { this.isWeared = false; }

    @Override
    public String toString() {
        return String.format("%s (%.1f kg, %d oro) POW:%d [%s]",
                getName(), getWeight(), getValue(), getPower(),
                isWeared ? "indossata" : "non indossata");
    }

    public static Weapon ArtigliM()  { return new Weapon(6.0,  40, "Gli artigli della giustizia di Manuel",  false, 5, 10); }
    public static Weapon AsciaK()    { return new Weapon(10.0,  35, "L'ascia oscura di Konrad",  false, 10, 15); }
    public static Weapon AlabardaA()    { return new Weapon(15.0,  55, "L'alabarda della distruzione di Andrea",    false, 10, 20); }
    public static Weapon CortelloS()     { return new Weapon(1.0,  1, "Cortellino svizzero",      false, 1, 2); }
    public static Weapon Bastone()     { return new Weapon(10.0,3, "Bastone",      false,5, 5); }
    public static Weapon SpadoneR()     { return new Weapon(30.0,1000, "Spadone dell'Onniscienza di Riccardo",    false,50, 250); }
    public static Weapon MartelloR()     { return new Weapon(30.0,1000, "Martello del Giudizio eterno di Roberto",    false,50, 250); }
}
