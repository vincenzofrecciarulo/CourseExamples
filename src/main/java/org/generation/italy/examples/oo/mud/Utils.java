package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.entities.enemies.Enemy;

import java.util.Random;

public class Utils {
    private static Random random=new Random();
    private final static int MAX_ROLL =100, MIN_ROLL =1;

    public static int throwDice(int luck){
        boolean unlucky=luck>=0? false : true;
        int selectedRoll=random.nextInt(MIN_ROLL, MAX_ROLL +1);
        int currentRoll;
        if(luck==0) return selectedRoll;
        for (int i = 1; i <= Math.abs(luck); i++) {
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
        else{
            IO.println("SCELTA NON VALIDA");
            StringBuilder sb= new StringBuilder();
            sb.append("LE OPZIONI DISPONIBILI SONO:\n [");
            for(int i=0;i<options.length-1;i++){
                sb.append(options[i]).append(",");
            }
            sb.append(options[options.length-1]).append("]");
            sb.append("\n").append(msg);
            msg=sb.toString();
            return Utils.choice(msg,options);
        }
    }
    public static void startCombat(Player player, Enemy enemy) throws InterruptedException {
        IO.println("IL COMBATTIMENTO TRA "+player.getName()+" E "
        +enemy.getName()+" HA INIZIO:\n");
        Thread.sleep(700);

        while (player.getHp()>0){
            IO.println(player.attack(enemy));
            if (enemy.getCurrentRoom()==null) break;
            IO.println(enemy.attack(player));
        }
        if (player.getHp()<=0)   gameOver(player);
    }
    public static void gameOver(Player player){
        IO.println("IL NOSTRO EROE E' MORTO");
        IO.println("LIVELLO RAGGIUNTO: "+player.getLevel());
        Main.running=false;
    }
}
