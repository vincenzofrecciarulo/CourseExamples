package org.generation.italy.examples.pokemon.util;

import com.generation.library.Console;

/**
 * Wrapper sicuro attorno a Console che gestisce:
 * - input non numerico (InputMismatchException, NumberFormatException)
 * - stringhe vuote o null
 * - valori fuori dal range atteso
 *
 * Ogni metodo blocca finché l'utente non inserisce un valore valido,
 * invece di far crashare il programma.
 */
public class SafeConsole {

    /**
     * Legge un intero qualsiasi.
     * Se l'utente inserisce testo non numerico, chiede di riprovare.
     */
    public static int readInt() {
        while (true) {
            try {
                return Console.readInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("  [!] Devi inserire un numero intero. Riprova:");
                System.out.print("  > ");
            } catch (java.util.NoSuchElementException e) {
                System.out.println("  [!] Nessun input ricevuto. Riprova:");
                System.out.print("  > ");
            } catch (Exception e) {
                System.out.println("  [!] Input non valido (" + e.getClass().getSimpleName() + "). Riprova:");
                System.out.print("  > ");
            }
        }
    }

    /**
     * Legge un intero nel range [min, max] inclusi.
     * Rifiuta valori fuori range e input non numerici.
     */
    public static int readInt(int min, int max) {
        if (min > max) throw new IllegalArgumentException("min (" + min + ") > max (" + max + ")");
        while (true) {
            int value = readInt();
            if (value >= min && value <= max) return value;
            System.out.printf("  [!] Scegli un numero tra %d e %d:%n  > ", min, max);
        }
    }

    /**
     * Legge una stringa non vuota e non composta solo da spazi.
     * Ritaglia gli spazi iniziali/finali (trim).
     */
    public static String readString() {
        while (true) {
            try {
                String s = Console.readString();
                if (s != null && !s.isBlank()) return s.trim();
                System.out.println("  [!] Il testo non può essere vuoto. Riprova:");
                System.out.print("  > ");
            } catch (java.util.NoSuchElementException e) {
                System.out.println("  [!] Nessun input ricevuto. Riprova:");
                System.out.print("  > ");
            } catch (Exception e) {
                System.out.println("  [!] Errore di input. Riprova:");
                System.out.print("  > ");
            }
        }
    }

    private SafeConsole() {}
}