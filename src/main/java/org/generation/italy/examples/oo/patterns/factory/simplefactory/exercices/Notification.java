package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

// Questa interfaccia rappresenta il concetto generico di notifica
// Qualunque tipo di notifica deve essere in grado di inviare un messaggio a un destinatario
// Non ci interessa ancora come viene inviata
public interface Notification {
    void send(String message, String recipient);
}
