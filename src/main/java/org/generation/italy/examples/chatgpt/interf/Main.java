package org.generation.italy.examples.chatgpt.interf;

public class Main {
    public static void main(String[] args){
        Swimmable s = new Fish();
        s.swim();

        if (s instanceof Flyable){
            Flyable f = (Flyable) s;
            f.fly();
        }

        Duck duck = new Duck("Duffy Duck");
        Swimmable s_duck = duck;
        Flyable f_duck = duck;
        s_duck.swim();
        f_duck.fly();

        Animal a = new Duck("Donald");
        if (a instanceof Swimmable){
            Swimmable s_a = (Swimmable) a;
            s_a.swim();
        // Avremmo potuto anche scrivere:
        // if (a instanceof Swimmable s_a){
        //     s_a.swim();
        //     }
        }
    }
}
