package org.generation.italy.examples.arrays.casa;

import java.util.Arrays;

public class Ex2 {
        public static void main(String[] args){
            int[]  array= new int[10];

            populateArray(array);
            IO.println(Arrays.toString(array));
        }

        public static void populateArray(int[] array) {
            for(int i=0;i<array.length;i++){
                array[i]=(int)(Math.random()*10)+1;
            }

        }

        public static boolean hasDuplicates(int[] array) {
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

