package org.generation.italy.examples.arrays;

public class Exercise1BisTris {
    /*
    Dato un array di 10 elementi di qualunque tipo, scrivere una funzione che prenda un array di quel tipo
    e lo restituisca con gli elementi in ordine inverso.

    Dato un array di 10 elementi di qualunque tipo, scrivere una funzione che prenda un array di quel tipo
    e lo restituisca con gli elementi in ordine inverso
    senza utilizzare un array temporaneo (termine tecnico: in-place, cioè gli elementi rimangono
    sempre all’interno dell’array)

    si potrebbe scriverne uno per ogni tipo di array, con lo stesso nome e
    cambiando solo i parametri, e dovrebbe funzionare con ogni tipo di array.
    In ogni caso, non penso sia quello che intendeva Roberto.

    questo metodo lavora in-place (non crea array, modifica lo stesso array).
    in questi casi meglio non ritornare un'altra array reference,
    ma scrivere il metodo come void, siccome stiamo già lavorando
    sull'oggetto che ci interessa.
     */
    public static void invertArray(int[] arr) {
        for (int i = 0, j = arr.length-1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

