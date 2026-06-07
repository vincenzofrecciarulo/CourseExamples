<<<<<<<< HEAD:src/main/java/org/generation/italy/examplesMio/ooMio/mudMio/equipmentMio/Item.java
package org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio;

public class Item {
========
package org.generation.italy.examples.oo.mud.world;

public class Item {
    private static int nextId = 1;
    private final int id;
    private double weight;
    private int value;
>>>>>>>> master:src/main/java/org/generation/italy/examples/oo/mud/world/Item.java
    private String name;
    private int value;
    private double weight;

    public Item(double weight, int value, String name) {
<<<<<<<< HEAD:src/main/java/org/generation/italy/examplesMio/ooMio/mudMio/equipmentMio/Item.java
========
        this.id = nextId++;
        this.weight = weight;
        this.value = value;
>>>>>>>> master:src/main/java/org/generation/italy/examples/oo/mud/world/Item.java
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

<<<<<<<< HEAD:src/main/java/org/generation/italy/examplesMio/ooMio/mudMio/equipmentMio/Item.java
    public int getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }


========
    public int getId() {
        return id;
    }
>>>>>>>> master:src/main/java/org/generation/italy/examples/oo/mud/world/Item.java
}
