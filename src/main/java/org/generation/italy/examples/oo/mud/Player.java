package org.generation.italy.examples.oo.mud;

public class Player extends Entity{
    private Role role;
    private int luck;
    private static final int INITIAL_LEVEL = 1;

    public Player (String name, Role role){
        super(role.getHpIniziali(), name, INITIAL_LEVEL);
        this.role=role;
        this.luck = role.getLuckIniziale();
    }

}

