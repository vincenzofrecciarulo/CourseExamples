package org.generation.italy.examples.oo.mud;

public class Item {
    private double weight;
    private int value;
    private String name;

    public Item(double weight, int value, String name) {
        this.weight = weight;
        this.value = value;
        this.name = name;
    }

    public String getName()   { return name; }
    public double getWeight() { return weight; }
    public int getValue()     { return value; }

    @Override
    public String toString() {
        return String.format("%s (%.1f kg, %d oro)", name, weight, value);
    }

    // ---------------------------------------------------------------
    // Factory: oggetti comuni
    // ---------------------------------------------------------------

    // Consumabili
    public static Item potioneCura()      { return new Item(0.5,  20, "Pozione di Cura"); }
    public static Item bendaSacra()       { return new Item(0.3,  15, "Benda Sacra"); }
    public static Item fungoVelenoso()    { return new Item(0.2,   5, "Fungo Velenoso"); }
    public static Item boccaleBirra()     { return new Item(1.0,   8, "Boccale di Birra"); }

    // Materiali / tesori
    public static Item pepitaOro()        { return new Item(5.0,  80, "Pepita d'Oro"); }
    public static Item mappasgualcita()   { return new Item(0.1,  25, "Mappa Sgualcita"); }
    public static Item libroIncantesimi() { return new Item(0.5, 200, "Libro degli Incantesimi"); }
    public static Item amuletoFulmine()   { return new Item(1.0, 150, "Amuleto del Fulmine"); }
    public static Item coronaArgento()    { return new Item(2.0, 250, "Corona d'Argento"); }
    public static Item uovoDrago()        { return new Item(1.0,1000, "Uovo di Drago"); }
    public static Item picconeIncantato() { return new Item(3.0,  60, "Piccone Incantato"); }
    public static Item ramoAppuntito()    { return new Item(1.0,  12, "Ramo Appuntito"); }
}