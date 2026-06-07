package org.generation.italy.examplesMio.ooMio;

// smp = square meter price
public class House {
    String address;
    int area;
    int spm;

    public House(String address, int area, int spm) {
        this.address = address;
        this.area = area;
        this.spm = spm;
    }

    public int getPrice(){
        return spm * area;
    }

    public String toString(){
        return "Indirizzo: " + address + " " + "Area: " + area + "MQ" + " Prezzo al MQ: " + getPrice();
    }

}
