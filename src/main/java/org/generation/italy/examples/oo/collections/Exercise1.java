package org.generation.italy.examples.oo.collections;

import java.util.*;

public class Exercise1 {


    static String getModa(String array[]){

        Map<String,Integer>  presenze = new HashMap<>();
        int count, maxCount = 0;
        String finalMod ="";

        for(String s: array){
            count = presenze.getOrDefault(s, 0)+1;

            if(count>maxCount){
                maxCount = count;
                finalMod = s;
            }
        }

        return finalMod;
    }
}
