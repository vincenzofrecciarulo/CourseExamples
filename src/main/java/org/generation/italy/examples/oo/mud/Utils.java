package org.generation.italy.examples.oo.mud;

import java.util.Random;

public class Utils {
    private static Random random=new Random();
    private final static int MAX_ROLL =100, MIN_ROLL =1;
    public static int throwDice(int luck){
        boolean unlucky=luck>=0? false : true;
        int selectedRoll=random.nextInt(MIN_ROLL, MAX_ROLL +1);
        int currentRoll;
        if(luck==0) return selectedRoll;
        for (int i = 1; i < Math.abs(luck)+1; i++) {
            currentRoll= random.nextInt(MIN_ROLL, MAX_ROLL +1);
            if(unlucky) selectedRoll= currentRoll<selectedRoll? currentRoll : selectedRoll;
            else selectedRoll= currentRoll>selectedRoll? currentRoll : selectedRoll;
        }
        return selectedRoll;
    }
    public static String choice(String msg,String... options){
        String selected=IO.readln(msg).toLowerCase().trim();
        boolean validSelection=false;
        for(String s : options){
            if(selected.equalsIgnoreCase(s)){
                validSelection=true;
                break;
            }
        }
        if(validSelection) return selected;
        return Utils.choice("SCELTA NON VALIDA \n"+msg,options);
    }
}
