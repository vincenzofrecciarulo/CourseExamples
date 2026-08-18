package org.generation.italy.examples.jdbc;

// Qui creiamo una nostra exception personalizzata
// DataException è una Exception grazie all'ereditarietà.
public class DataException extends Exception {
    public DataException (String message, Exception cause){
        super(message,cause); // stiamo chiamando un costruttore della classe madre Exception
    }

//    Possiamo immaginare Exception fatta così:
//    public class Exception {
//
//        private String message;
//        private Throwable cause;
//
//        public Exception(String message, Throwable cause) {
//            this.message = message;
//            this.cause = cause;
//        }
//    }

    //NOTA: Throwable a sua volta è un'eccezione (la madre di tutte), oppure noi possiamo mettere
    // Exception perché tanto di errori non ne gestiamo
    // e sta dentro il costruttore
}
