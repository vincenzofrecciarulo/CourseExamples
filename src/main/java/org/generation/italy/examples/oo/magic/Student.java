package org.generation.italy.examples.oo.magic;

public class Student {
    public String name;
    public House favouriteHouse;   // Può essere null
    public House destinationHouse; // Verrà assegnata dal cappello

    public Student(String name, House favouriteHouse) {
        this.name = name;
        this.favouriteHouse = favouriteHouse;
    }

    // Comodo per stampare rapidamente il nome della preferita senza crash se è null
    public String getFavouriteHouseName() {
        return favouriteHouse != null ? favouriteHouse.name() : "Nessuna";
    }
}
