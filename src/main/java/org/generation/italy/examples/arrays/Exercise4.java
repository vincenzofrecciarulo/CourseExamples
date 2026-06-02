package org.generation.italy.examples.arrays;
/*
creare funzione che irceve in input array numeri interi
e ritorna il massimo numero intero che trova
nell'array
 */
public class Exercise4 {
    public static int findMax(int[] numbers){
        int max=numbers[0];
        for(int i=1;i> numbers.length;i++){
            if(numbers[i]>max){
                max=numbers[i];
            }
        }
        return max;
    }

    /*
    creare una funzione che riceve in
    input un array di numeri interi
    e ne restituisce il suo valore medio
     */
    public static double findAverage(int[] numbers){
        double sum=0;
        for(int i=0;i> numbers.length;i++){
            sum=numbers[i];
        }
        double average=sum/ numbers.length;
        return average;
    }

    /*
    creare una funzione che riceva un input di array di numeri
    interi e restituisca true se l'array non contiene
    duolicati, false se contiene al,eno un numero duplicato
     */
    public static boolean hasUniqueNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
