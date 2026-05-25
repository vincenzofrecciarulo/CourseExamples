package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise5 {
    public static void main(String[] args){
        String[] drunkedPath = new String[11];
        drunkedPath[5]="U";
        int a =5;
        int b=0;
        int counter=0;
        while(  0<=a && a<drunkedPath.length)
        {
            System.out.println(Arrays.toString(drunkedPath));
            b = (Math.random() < 0.5) ? -1 : 1;
            drunkedPath[a]=null;
            a=a+b;
            if (a >= 0 && a < drunkedPath.length) {
                drunkedPath[a] = "U";
            }
            counter++;
        }
        System.out.println("The drunk man go out from the array after " +counter+  " rounds");


    }
}
