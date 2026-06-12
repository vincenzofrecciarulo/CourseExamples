package org.generation.italy.examples.oo.lambdaandstreams;
/*
Ex9
Dato un ArrayList di String della forma “NomeProdotto - PrezzoDouble” (es. “Portatile - 999.99), scrivere uno Stream che:
Trasforma le String in oggetti di tipo Product (che contengono una String productName e un double Price)
Salva il totale dei prezzi in una variabile
Restituisce una List<Product> contenente tutti gli oggetti di tipo Prodotto ottenuti

Ex10
Dato un ArrayList di Transaction così definite:
public class Transaction {
	Guest g;
	Int amount; //prezzo pagato nella transazione
	//eventuali altre variabili e/o funzioni a vostra discrezione
}
Contenenti un Guest così definito:
public class Guest {
	String name, surname;
	LocalDate dateOfBirth;
	//eventuali altre variabili e/o funzioni a vostra discrezione
},

Scrivere uno Stream che:
Filtra tutte le transazioni di un determinato Guest (identificato dal terzetto name, surname, dateOfBirth)
Applica uno sconto di 1€ se attualmente il Guest è minorenne (es. 15€ viene scontato a 14€)
Restituisce la somma di tutti gli amount del Guest

Poi scrivere un secondo Stream che rimuove le transazioni di quel Guest ed eseguirli entrambi


*/

public class Ex1 {
}
