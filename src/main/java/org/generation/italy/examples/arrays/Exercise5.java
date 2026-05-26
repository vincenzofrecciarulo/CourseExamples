package org.generation.italy.examples.arrays;
/*
fare funzione che prende array e mi da' moda,
se ce n'è più di una va bene che ne ritorni una qualsiasi
 */
public class Exercise5 {
    public static int[] Moda(int[] arrayNum) {
            int maxOccurrence=0;
            int[] arrayModa = new int[arrayNum.length];

            for(int i=0;i< arrayNum.length;i++) {
                int occurrencei=occurencesNum(arrayNum, arrayNum[i]);
                if(occurrencei>maxOccurrence){
                    maxOccurrence=occurrencei;
                }
            }

            for (int i=0;i<arrayNum.length;i++){
                if(occurencesNum(arrayNum[i])==maxOccurrence){

                }
            }
            return arrayModa;
    }

    private static int occurencesNum(int[] arrayNum, int numberToCount) {
    int conti = 0;
    for (int i = 0; i < arrayNum.length; i++) {
        if (arrayNum[i] == numberToCount) {
            conti++;
        }
    }
    return conti;
    }

}