package org.generation.italy.examples.oo;

public class Circle {
    double radius; //Variabile statica 1 sola copia nella classe (appartiene alla classe)

    static int counter;

    public Circle() {
        //Va ad allocare la memoria necessaria per costruire un cerchio l'area di memoria dove i costruttori creano gli oggetti si chiama heap e poi azzera quella memoria
    }

    public Circle(double radius) { //I costruttori ritornano sempre l'indirizzo dell'oggetto che hanno fimito di crerare
        this.radius = radius; //Nel costruttore this è l'indirizzo dell'oggetto che sto costruendo
        IO.println(this);
    }

    double getPerimeter() {//la definizione più vicina quella più locale ha la priorità
        IO.println(this);
        return 2 * Math.PI * this.radius; //this rappresenta il contesto dell'oggetto(è un puntatore all'oggetto a cui è stato chiamato il metodo)
    }

    double getArea() {

        return radius * radius * Math.PI;
    }


    static void main() {
     /*   int x = 3;
        Circle c = new Circle();   //Variabile di tipo Cerchio new è il costruttore di default di Cerchio
        Circle.counter++;
        c.radius = 20;
        IO.println(c);
        double p = c.getPerimeter();//Esegue nel contesto dell'oggetto c invece un metodo statico non ha il this
        Circle d = new Circle();
        Circle.counter++;
        System.out.println(p);
        IO.println(d);
        double p2 = d.getPerimeter();
        System.out.println(p2);
        System.out.println(Circle.counter);
        Circle circle = c; //copia l'indirizzo del cerchio c in circle
        System.out.println(circle.radius);
        Circle y = new Circle(50);
        System.out.println(y);*/

        /*Person p1 = new Person("chiara", "De Santis", "2000-03-20", "Female");
        System.out.println(p1);*/

        House h = new House("Via Verdi 100, Cassano", 100, 1000);
        System.out.println(h);


    }

}
