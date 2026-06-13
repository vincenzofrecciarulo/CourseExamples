package org.generation.italy.examples.exathome.abstraction.ex01;

public class Start {
    public static void main(String[] args){
        Cerchio c = new Cerchio("cerchio", 5.4);
        Rettangolo r = new Rettangolo("rettangolo", 4.1, 3.1);

        System.out.println(c.stampaNome());
        System.out.println("L'area del cerchio è: " + c.area());
        System.out.println("");
        System.out.println(r.stampaNome());
        System.out.println("L'area del rettangolo è: " + r.area());
    }
}
