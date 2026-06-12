package org.generation.italy.examples.oo.lambdaandstreams;

public class Product {
    private String nameProducts;
    private double price;

    public Product(String nameProducts, double price) {
        this.nameProducts = nameProducts;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNameProducts(String nameProducts) {
        this.nameProducts = nameProducts;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameProducts='" + nameProducts + '\'' +
                ", price=" + price +
                '}';
    }
}
