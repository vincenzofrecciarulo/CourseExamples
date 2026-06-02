package org.generation.italy.examples.oo.mud;

public enum Role {
    STOICO(25,25,"O taci, o di' qualcosa che sia meglio del silenzio "+"\n"),
    EPICUREO(15,35,"Hit me baby one more time "+"\n"),
    CINICO(40,10,"Scemo chi legge! "+"\n");


    private final int hpIniziali;
    private final int luckIniziale;
    private final String motto;

    public int getHpIniziali() {
        return hpIniziali;
    }

    public int getLuckIniziale() {
        return luckIniziale;
    }

    public String getMotto() {
        return motto;
    }

    Role(int hpIniziali, int luckIniziale, String motto) {
        this.hpIniziali = hpIniziali;
        this.luckIniziale = luckIniziale;
        this.motto = motto;
    }
}
