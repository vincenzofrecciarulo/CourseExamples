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

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals (Object o) { // riscriviamo l'equals per farsì che vada a comparare solo il "nome" dell'oggetto e non l'indirizzo.
        if (o == null || o.getClass() != this.getClass()){ // controlla se l'oggetto è null o se è di classe diversa.
            return false;
        }
        Item other = (Item) o;
        return this.name.equals(other.name); // tornerà true solo se l'oggetto da me indicato ha lo stesso nome dell'oggetto nell'inventario.
    }

    @Override
    public int hashCode () { // andiamo anche a fare l'ovverride dell'hashcode subito dopo l'equals
        return name.hashCode(); // ora equals e hashcode sono uguali in quanto controllano entrambi il nome.
    }
}
