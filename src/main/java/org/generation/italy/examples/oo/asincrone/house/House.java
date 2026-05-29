package org.generation.italy.examples.oo.asincrone.house;

public class House {

    public String address;
    public int area;
    public int sqm;

    public House (String address, int area, int sqm){
        this.address = address;
        this.area = area;
        this.sqm= sqm;
    }

    public int getPrice (){
        return area * sqm;
    }

    public String toString(){
        return "Indirizzo: "+ address +" "+"Area: "+area+" "+"Prezzo Casa: "+getPrice()+"€";
    }

}
