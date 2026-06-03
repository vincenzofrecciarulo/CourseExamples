package org.generation.italy.examples.oo.mudMio;

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


    // Materiali / tesori
    public static Item pepitaOro()        { return new Item(5.0,  80, "Pepita d'Oro"); }
    public static Item mappasgualcita()   { return new Item(0.1,  25, "Mappa Sgualcita"); }
    public static Item libroIncantesimi() { return new Item(0.5, 200, "Libro degli Incantesimi"); }
    public static Item amuletoFulmine()   { return new Item(1.0, 150, "Amuleto del Fulmine"); }
    public static Item coronaArgento()    { return new Item(2.0, 250, "Corona d'Argento"); }
    public static Item uovoDrago()        { return new Item(1.0,1000, "Uovo di Drago"); }
    public static Item picconeIncantato() { return new Item(3.0,  60, "Piccone Incantato"); }
    public static Item ramoAppuntito()    { return new Item(1.0,  12, "Ramo Appuntito"); }
    public static Item MappaSgualcita()            {return new Item(0.4,200,"Mappa sgualcita");}
    public void useMappaSgualcita() {
        IO.println("""
    ╔══════════════════════════════════════╗
    ║           MAPPA DEL MONDO            ║
    ╠══════════════════════════════════════╣
    ║                                      ║
    ║         [Torre del Mago]             ║
    ║               │N                     ║
    ║  [Taverna] W──[Mercato]──E [Foresta] ║
    ║               │S              │S     ║
    ║          [Tempio]         [Rovine]   ║
    ║               │S              │S     ║
    ║          [Miniera]         [Cripta]  ║
    ║                               │S     ║
    ║                           [Tana del] ║
    ║                           [Serpente] ║
    ╚══════════════════════════════════════╝
    """);
    }
}