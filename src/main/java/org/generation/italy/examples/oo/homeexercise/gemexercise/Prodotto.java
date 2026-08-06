package org.generation.italy.examples.oo.homeexercise.gemexercise;

public class Prodotto {
    private String nome;
    private double prezzo;
    private int quantità;

    public Prodotto(String nome, double prezzo, int quantità) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantità = quantità;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public String getNome() {
        return nome;
    }

    public boolean scaleProductsQuantity(){
        if(this.quantità>0){
            this.quantità--;
            return true;
        }
            return false;
    }


}
