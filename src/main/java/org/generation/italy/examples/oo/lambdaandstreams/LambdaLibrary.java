package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class LambdaLibrary {
    private static int count;
    private static int sum;
    private static double totalPrice;

    // Ex1
    static Consumer<String> charCounter = (a) -> count += a.length();

    // Ex2
    static Function<String, String> standardize = a -> a.trim().toLowerCase();

    // Ex3
    static BinaryOperator<String> concat = (a, b) -> a + " " + b;

    // Ex5
    static Predicate<Integer> isEven = n -> n % 2 == 0;

    // Ex6
    static Consumer<Integer> addToSum = n -> sum += n;

    // Ex7
    static Function<Integer, Integer> square = n -> n * n;

    // Ex9 - parsing "NomeProdotto - PrezzoDouble" -> Product
    static Function<String, Product> parseProduct = s -> {
        String[] parts = s.split(" - ");
        return new Product(parts[0], Double.parseDouble(parts[1]));
    };

    // Ex10 - accumula il prezzo nella variabile statica totalPrice
    static Consumer<Product> addPrice = p -> totalPrice += p.getPrice();

    // Ex10 (Transaction) - dato un Guest, restituisce un Predicate che filtra le sue transazioni
    static Predicate<Transaction> makeGuestFilter(Guest g) {
        return t -> t.belongsTo(g);
    }

    // Ex10 (Transaction) - applica sconto di 1 se il guest è minorenne
    static ToIntFunction<Transaction> applyMinorDiscount =
            t -> t.getGuest().isMinor() ? t.getAmount() - 1 : t.getAmount();

    public static int getCount()          { return count; }
    public static int getSum()            { return sum; }
    public static double getTotalPrice()  { return totalPrice; }
}
