package org.generation.italy.examples.oo.mud.entities;

public class GuardEntity extends Entity{
    private static final int HP = 1;
    private static final String NAME = "Ciro La Guardia";
    private static final int LEVEL = 1;

    public GuardEntity() {
        super(GuardEntity.HP, GuardEntity.NAME, GuardEntity.LEVEL);
    }

    @Override
    public void interact(Player player){
        IO.println("Salve avventuriero, non è una bellissima giornata?");
    }
}
