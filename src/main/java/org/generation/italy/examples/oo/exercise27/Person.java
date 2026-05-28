package org.generation.italy.examples.oo.exercise27;
/*Esercizio #27
• aggiungere la proprietà String gender alla classe Person
• modificare il costruttore per ricevere anche un parametro String g che andrà a finire nella
proprietà gender
• modificare il metodo toString() per incorporare nel return anche il valore della variabile
Riprendi in mano la classe Person.
Imposta la visibilità di tutte le proprietà a private.
Scrivi getter e setter “stupidi” per tutte le proprietà.
Modifica i getter e i setter per fare in modo che non accettino, né restituiscano, valori null*/

public class Person {

   private String name;
   private String surname;
   private int age;
   private String gender;

   public Person(String name, String surname, int age, String gender) {
      this.name = name;
      this.surname = surname;
      this.age = age;
      this.gender = gender;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name==null?"Unknown":name;
   }

   public String getSurname() {
      return surname==null?"":name;
   }

   public void setSurname(String surname) {
      this.surname = surname==null?"Unknown":surname;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getGender() {
      return gender==null?"":gender;
   }

   public void setGender(String gender) {
      this.gender = gender==null?"Unknown":gender;
   }
}