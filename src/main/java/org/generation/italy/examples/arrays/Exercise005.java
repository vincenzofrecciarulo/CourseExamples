package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*dato un array di 11 String di cui 10 vuote e 1 di valore U
inizialmente all'indice 5 simulare il problema del cammino dell’ubriaco:
A ogni passo l’ubriaco “U” si sposta casualmente verso sinistra o verso
destra di 1 posizione nell’array. L’ubriaco continua a spostarsi
finché non esce dall’array. Ad ogni passo, stampare la visualizzazione
grafica di tutto l’array per mostrare la posizione attuale dell’ubriaco.
Il programma non deve crashare quando l’ubriaco sta per uscire dall’array.
Alla fine dell’esecuzione, stampare il numero di passi che
l’ubriaco ha compiuto prima di uscire.
*/
public class Exercise005 {
   public static void main(String[] args){
       String[] drunk={"","","","","","U","","","","",""};
       int a=5;
       int steps=0;
       while(a>=0 && a<drunk.length){
           drunk[a]="";
           int i=(int)(Math.random()*100)+1;
           if(i>50){
               a=a+1;
           }else{
               a=a-1;
           }
           steps++;
           if (a >=0 && a<drunk.length) {
               drunk[a] = "U";
               IO.println(Arrays.toString(drunk));
           }
       }
       IO.println(steps+"passi");

   }
}
