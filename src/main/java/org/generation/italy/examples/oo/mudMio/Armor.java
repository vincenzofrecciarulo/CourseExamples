package org.generation.italy.examples.oo.mudMio;

public class Armor extends Item {
    private boolean isWeared;
    private int defense;

    public Armor(double weight, int value, String name, boolean isWeared, int defense) {
        super(weight, value, name);
        this.isWeared = isWeared;
        this.defense = defense;
    }

    public boolean isWeared()  { return isWeared; }
    public int getDefense()    { return defense; }
    public void wear()         { this.isWeared = true; }
    public void remove()       { this.isWeared = false; }

    @Override
    public String toString() {
        return String.format("%s (%.1f kg, %d oro) DEF:%d [%s]",
                getName(), getWeight(), getValue(), defense,
                isWeared ? "indossata" : "non indossata");
    }

    // ---------------------------------------------------------------
    // Factory: armature
    // ---------------------------------------------------------------

    public static Armor corazzaSpezzata()  { return new Armor(6.0,  40, "Corazza Spezzata",  false, 2); }
    public static Armor elmoFerraglia()    { return new Armor(3.0,  35, "Elmo di Ferraglia",  false, 1); }
    public static Armor giubboDiCuoio()    { return new Armor(4.0,  55, "Giubbo di Cuoio",    false, 3); }
    public static Armor scudoDiFerro()     { return new Armor(5.0,  70, "Scudo di Ferro",      false, 4); }
    public static Armor corazzaReale()     { return new Armor(10.0,300, "Armatura Reale",      false,10); }
    public static Armor scagliaDrago()     { return new Armor(15.0,800, "Scaglia di Drago",    false,18); }
}