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

        boolean hasBanan = basket.containsProductByName("Банан");
        System.out.println("Есть ли в корзине банан? " + hasBanan);
        boolean hasApple = basket.containsProductByName("Яблоко");
        System.out.println("Есть ли в корзине яблоко? " + hasApple);
        boolean hasMilk = basket.containsProductByName("Молоко");
        System.out.println("Есть ли в корзине молоко? " + hasMilk);
        boolean hasMeat = basket.containsProductByName("Мясо");
        System.out.println("Есть ли в корзине мясо? " + hasMeat);
        boolean hasSugar = basket.containsProductByName("Сахар");
        System.out.println("Есть ли в корзине сахар? " + hasSugar);

        boolean hasFish = basket.containsProductByName("Рыба");
        System.out.println("Есть ли в корзине рыба? " + hasFish);
        boolean hasMango = basket.containsProductByName("Манго");
        System.out.println("Есть ли в корзине манго? " + hasMango);
        boolean hasPasta = basket.containsProductByName("Паста");
        System.out.println("Есть ли в корзине паста? " + hasPasta);

        Product salat = new Product("Салат", 60);

        basket.addProduct(salat);

        basket.clearBasket();

        basket.printContents();

        int emptyTotalCost = basket.getTotalCost();
        System.out.println("Стоимость пустой корзины: " + emptyTotalCost);

        boolean hasBananInEmptyBasket = basket.containsProductByName("Банан");
        System.out.println("Есть ли банан в пустой корзине? " + hasBananInEmptyBasket);

    }
}
