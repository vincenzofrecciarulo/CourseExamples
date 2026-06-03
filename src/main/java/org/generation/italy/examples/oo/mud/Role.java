package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public enum Role {
    STOICO(25,25,"O taci, o di' qualcosa che sia meglio del silenzio "+"\n"),
    EPICUREO(15,35,"Hit me baby one more time "+"\n"),
    CINICO(40,10,"Scemo chi legge "+"\n");


    private final int hpIniziali;
    private final int luckIniziale;
    private final String motto;
    private final ArrayList<Move> moves;

    public ArrayList<Move> roleMoves(){
        ArrayList<Move> moves=new ArrayList();
        switch (this){
            case CINICO :
                Move commentoTagliente= new Move("Commento tagliente", 6, "Un commento tagliente sferza l'aria e l'ego dell'avversario!");
                Move rifiutoTotale= new Move("Rifiuto Totale", 5, "Rigetti tutto ciò che l'avversario dice, fa e rappresenta");
                Move svergognatezza= new Move("Svergognatezza", 10, "Mentre ti scaccoli dici la verità nuda e cruda. L'avversario piange.")

                moves.add(commentoTagliente);
                moves.add(rifiutoTotale);
                moves.add(svergognatezza);

                break;
            case EPICUREO:
                Move paradossoDelPiacere= new Move("Paradosso del piacere", 15, " Dimostri che il piacere vero è l'assenza di dolore, mandando l'avversario in confusione");
                Move pioggiaDiAtomi =new Move("Pioggia di atomi", 12, "Lanci una raffica di fisica epicurea. Nessuno ci capisce niente.");
                Move atarassiaOffensiva =new Move("Atarassia offensiva", 8, "La tua calma è così irritante che fa danni.");

                moves.add(paradossoDelPiacere);
                moves.add(pioggiaDiAtomi);
                moves.add(atarassiaOffensiva);

                break;
            case STOICO:
                Move sillogismo = new Move("Sillogismo implacabile", 12, "Una logica così ferrea che fa male alla testa.");
                Move apatheia = new Move("Apatheia", 7, "Non reagisci. L'avversario si innervosisce e si fa male da solo.");
                Move mementoMori = new Move("Memento mori", 9, "Ricordi a tutti che si muore. L'umore crolla.");

                moves.add(sillogismo);
                moves.add(apatheia);
                moves.add(mementoMori);

                break;
        }
        return moves;
    }

    public int getHpIniziali() {
        return hpIniziali;
    }

    public int getLuckIniziale() {
        return luckIniziale;
    }

    public String getMotto() {
        return motto;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    Role(int hpIniziali, int luckIniziale, String motto) {
        this.hpIniziali = hpIniziali;
        this.luckIniziale = luckIniziale;
        this.motto = motto;
        this.moves = roleMoves();
    }
}
