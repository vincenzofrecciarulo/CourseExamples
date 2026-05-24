package org.generation.italy.examples.homework;

public class Exercise5 {
    /*
    5) Scrivi una funzione che riceve in input un numero intero e ritorna il fattoriale di quel numero
     */

    static int doFactorial(int num) throws Exception {
        if(num < 0){
            throw new Exception();
        }
        int result = 1;
        for(int i = num; num > 1; num--){
            result *= num;
        }
        return result;
    }

}
