package org.generation.italy.examples.manu.esercizio3;

/* 3. Rettangolo e metodi di calcolo
      Crea una classe Rettangolo con:
      - base;
      - altezza;

      Implementa:
      - calcolaArea();
      - calcolaPerimetro()

      Crea più oggetti e confronta i risultati.

      Obiettivo - Prendere confidenza con:
      oggetti multipli
      metodi che elaborano dati interni
*/

public class Main {
    public static void main(){
        Rettangolo r1 = new Rettangolo(3,5);
        Rettangolo r2 = new Rettangolo(4,6);

        // perimetro e area del primo rettangolo
        if((r1.getBase()>0) && (r1.getHeight()>0)){
            IO.println("Perimetro r1: " + r1.findPerimeter());
            IO.println("Area r1: " + r1.findArea());
        }else{
            IO.println("Reinserisci i dati (>0) del primo rettangolo perchè non vanno bene per il calcolo del perimetro e dell'area!");
        }

        IO.println(" ");

        // perimetro e area del secondo rettangolo
        if((r2.getBase()>0) && (r2.getHeight()>0)){
            IO.println("Perimetro r2: " + r2.findPerimeter());
            IO.println("Area r2: " + r2.findArea());
        }else{
            IO.println("Reinserisci i dati (>0) del secondo rettangolo perchè non vanno bene per il calcolo del perimetro e dell'area!");
        }
    }
}