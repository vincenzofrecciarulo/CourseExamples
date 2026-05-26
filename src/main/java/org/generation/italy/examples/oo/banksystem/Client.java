package org.generation.italy.examples.oo.banksystem;

public class Client {
// Un client ha un nome, un cognome, una data di nascita e un sesso
// Inoltre puo avere da 0 a 5 account associati a lui e
// ha un metodo addAccount che aggiunge a un array di Account un account e non deve aggiungere oltre il limite (deve ritornare un boolean)
// inoltre deve avere un metodo removeAccount che prende come input un numero i che rimuove un account nella posizione i dell'array
// anche questo deve ritornare true o false a seconda se ha rimosso o meno
// inoltre il cliente avra un metodo getTotalBalance che restituisce il balance totale di tutti i suoi conti
// OPZIONALE ha un ultimo metodo di nome transfer che prende come input due interi i e j, e un double amount che
// trasferisce da un conto in posizione i a uno in posizione j di una cifra amount
// deve ritornare un boolean

public String name;
public String surname;
public int dateOfBirth;
public String gender;
public Account[] accounts;
public int numberOfAccounts;

public Client(String name, String surname, int dateOfBirth, String gender){
    this.name=name;           //salva il parametro name dentro l'attributo dell'oggetto(Client)
    this.surname= surname;
    this.dateOfBirth=dateOfBirth;
    this.gender=gender;
    accounts=new Account[5]; //crea l'array con 5 posizioni.
    numberOfAccounts=0;

}


}