package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {
    public static void main(String[]args) {

        ArrayList<String> products = new ArrayList<>();

        products.add("Cuffie - 72.50");
        products.add("Pane - 1.50");
        products.add("Acqua - 0.80");
        products.add("Pizza - 8.60");
        products.add("Coltello - 20");
        final double[] totalPrice = {0};
        List <Products> productsFinal= products.stream()
                .map(s->
                {
                    String[] parts = s.split(" - ");
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);

                    totalPrice[0] += price;

                    return new Products(name, price);
                })
                .toList();
        System.out.println(productsFinal);
        System.out.println("The total price is:"+ Arrays.toString(totalPrice));


    }
    private static class Products {
        String productName;
        double price;


        public Products(String productName, double price) {
            this.productName = productName;
            this.price = price;
        }
        @Override
        public String toString() {
            return productName + " - " + price;
        }

    }
}
