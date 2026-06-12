/*package org.generation.italy.examples.oo.abstraction.interfaces;

import java.util.Scanner;

public class AnimalsMain {
    public static void main(String[] args) {
        Mouse mouse1 = new Mouse();
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        Elephant ele1 = new Elephant();

        Scanner s = new Scanner(System.in);
        IO.println("let's do an illegal animal fight");
        int a;
        int b;
        int out = 0;
        Animal f1= new Animal();
        Animal f2= new Animal();
        do {
            IO.println("pick a number from 1 to 4 and choose\n 1 for the mouse\n 2 for the cat\n 3 for the dog\n 4 for the elephant");

            a = s.nextInt();
            switch (a) {
                case 1:
                    f1.nameSpecie() = mouse1.nameSpecie();
                    IO.println("you choose mouse and");
                    out = 0;
                    break;
                case 2:
                    f1 = cat1;
                    IO.println("you choose cat and");
                    out = 0;
                    break;
                case 3:
                    f1 = dog1;
                    IO.println("you choose dog and");
                    out = 0;
                    break;
                case 4:
                    f1 = ele1;
                    IO.println("you choose elephant and");
                    out = 0;
                    break;
                default:
                    System.out.println("number incorrect");
                    out = 1;
            }


        } while (out!= 0);

        do {
            IO.println("pick a second number from 1 to 4 and choose\n 1 for the mouse\n 2 for the cat\n 3 for the dog\n 4 for the elephant");

            b = s.nextInt();
            switch (a) {
                case 1:
                    f2 = mouse1;
                    IO.println("a mouse ");
                    out = 0;
                    break;
                case 2:
                    f2 = cat1;
                    IO.println("a cat ");
                    out = 0;
                    break;
                case 3:
                    f2 = dog1;
                    IO.println("a dog ");
                    out = 0;
                    break;
                case 4:
                    f2 = ele1;
                    IO.println("a elephant");
                    out = 0;
                    break;
                default:
                    System.out.println("number incorrect");
                    out = 1;
            }


        } while (out!= 0);
        IO.println("the fight is between a " + f1.nameSpecie() + ""+"and a "+f2.nameSpecie());
    }
} */

