package org.generation.italy.examples.arrays;

public class OurMath {

    public static int fact(int n) {

        int res = 1;
        for (int i=n; i>1; i--)
            res*=i;

        //output
        return res;
    }
}
