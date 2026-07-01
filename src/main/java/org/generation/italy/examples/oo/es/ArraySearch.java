package org.generation.italy.examples.oo.exercise;

public class ArraySearch {
    public static void main() {
        int[] array= getArray();
        int element=getElement();

        int index= indexOf(array,element);
        String msg= index>-1?
                "Elemento"+element+"trovato in posizione: "+(index+1):
                "Elemento"+element+"non trovato nell'array:\n"+array.toString();
        IO.println(msg);
    }

    private static int indexOf(int[] array, int element) {
        int startIndex=0;
        int endIndex=array.length-1;
        int index=-1;
        int i=0;
        while (startIndex<=endIndex) {
            if(array[i]<element) startIndex=i+1;
            else endIndex=i-1;
            i=(endIndex-startIndex/2)+startIndex;
            if(array[i]==element) {
                index=i;
                break;
            }
        }
        return index;
    }


    private static int getElement() {
       int element=Integer.parseInt(IO.readln("Inserire l'elemento da cercare: "));
       return element;
    }

    static int[] getArray(){
        int size=Integer.parseInt(IO.readln("Inserire il numero di elementi: "));
        int[] array=new int[size];
        for (int i = 0; i < size; i++) {
          array[i]=Integer.parseInt(IO.readln("Inserire l'elemento numero"+(i+1)+": "));
        }
        return array;
    }
}
