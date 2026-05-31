package org.generation.italy.examples.oo.mud.entities;

public class GuardNpc extends Entity{
    private static final int HP = 1;
    private static final String NAME = "Ciro La Guardia";
    private static final int LEVEL = 1;

    public GuardNpc() {
        super(GuardNpc.HP, GuardNpc.NAME, GuardNpc.LEVEL);
    }

    @Override
    public void interact(Player player){
        IO.println("Salve avventuriero, non è una bellissima giornata?");
    }
}
