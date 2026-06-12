package org.generation.italy.examples.moreexercises.ex01;

public abstract class Forma {
      protected String name; // nome della forma geometrica

      public Forma(String name) {
          this.name = name;
      }

      // metodo astratto
      public abstract double area();

      // metodo concreto
      public String stampaNome(){
          return "La forma geometrica è: " + this.name;
      }
}