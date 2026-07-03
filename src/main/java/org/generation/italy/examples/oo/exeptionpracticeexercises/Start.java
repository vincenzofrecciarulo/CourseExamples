package org.generation.italy.examples.oo.exeptionpracticeexercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Start {

    static void main() {
        /*
        String prompt = IO.readln("Inserire numero: ");
        try{
            int number = Integer.parseInt(prompt);
            System.out.println("Hai scelto "+number);
        } catch (NumberFormatException e) {
            System.out.println("Devi inserire un numero intero!");
        }
        */
        /*
        String prompt = IO.readln("Inserire primo numero ");
        String prompt2 = IO.readln("Inserire secondo numero ");
        double x = Double.parseDouble(prompt);
        double y = Double.parseDouble(prompt2);

        try {
          double result = division(x,y);
            System.out.println(result);
        } catch (ArithmeticException e ) {
            System.out.println(e.getMessage());
        }
        */
        try{
            int age = askAge();
            System.out.println(age);
        }catch (InvalidAgeException | NumberFormatException e){
            System.out.println(e.getMessage());
        }



    }
    public static double division(double a, double b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException("Non puoi dividere per 0!");
        }
        return  a/b;
    }

    public static String leggiPrimaRiga(String path) throws IOException{
         try(BufferedReader br = new BufferedReader(new FileReader(path))) {
             return br.readLine();
         }catch (IOException e){
             throw new IOException("Il file "+path+"non esiste");
         }
    }

    public static int askAge(){
        String prompt = IO.readln("Quanti anni hai? ");
        if(!prompt.matches("\\d+")){
            throw new NumberFormatException("Età deve essere un numero intero");
        }
       int age = Integer.parseInt(prompt);

        if(age<0){
            throw new InvalidAgeException("Età non può essere minore di 0");
        }
        return age;
    }
}
