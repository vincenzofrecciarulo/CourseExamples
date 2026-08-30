package org.generation.italy.examples.arrays.casa.esercizicolloquio;

public class EsercizioVocali {
    public static int contaVocali(String testo) {
        int conteggio = 0;
        // completa tu: scorri i caratteri della stringa e conta le vocali
        String vocali = "aeiouAEIOU";
        for(int i = 0; i < testo.length(); i++){
            char carattere = testo.charAt(i);
            if(vocali.indexOf(carattere) != -1){
                conteggio++;
            }
        }
        return conteggio;
    }
}
