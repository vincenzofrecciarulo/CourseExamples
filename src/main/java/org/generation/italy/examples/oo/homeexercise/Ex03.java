package org.generation.italy.examples.oo.homeexercise;

public class Ex03 {

    public static void main(String[] args){
        //1.Crea un array di interi con 8 voti (valori tra 1 e 10).

        int[] voti={3,4,5,6,7,8,9,10};
        int sum =0;

        //2.Usa un ciclo for classico per calcolare la media.

        for(int i=0;i<voti.length;i++){
            sum += voti[i];
        }
        double average = (double) sum /voti.length;
        System.out.println("La media dei voti è: " + average);

//3.Usa un ciclo for-each per stampare ogni voto e la sua valutazione con uno switch: 10 = "Eccellente", 8-9 = "Ottimo"
//6-7 = "Sufficiente", default = "Insufficiente".

        for(int v : voti){
            switch(v){
                case 10:
                    System.out.println(v + " " + "Eccellente");
                    break;
                case 8:
                case 9:
                    System.out.println(v + " " + "Ottimo");
                    break;
                case 6:
                case 7:
                    System.out.println(v + " " + "Sufficiente");
                    break;
                default:
                    System.out.println(v + " " + "Insufficiente");
                    break;
        }

        }

        //4.Stampa il voto minimo e massimo trovati con un ciclo for.

          int max= voti[0];
          int min= voti[0];

          for(int i=0;i<voti.length; i++){
              if(voti[i] >= max){
                  max =voti[i];
              }
          }
        System.out.println("Il voto massimo è: " + max);

          for(int i=0; i< voti.length; i++){
              if(voti[i] <= min ){
                  min = voti[i];
              }
          }
        System.out.println("Il voto minimo è: " + min);
    }
}


