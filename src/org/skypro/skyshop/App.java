package org.skypro.skyshop.app;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product banan = new Product("Банан", 120);
        Product apple = new Product("Яблоко", 150);
        Product milk = new Product("Молоко", 80);
        Product meat = new Product("Мясо", 160);
        Product sugar = new Product("Сахар", 90);

        basket.addProduct(banan);
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(meat);
        basket.addProduct(sugar);

        basket.printContents();

        int totalCost = basket.getTotalCost();
        System.out.println("Общая стоимость корзины: " + totalCost);


    }
}
