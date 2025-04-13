package org.skypro.skyshop.app;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        SimpleProduct banan = new SimpleProduct("Банан", 120);
        SimpleProduct apple = new SimpleProduct("Яблоко", 150);
        SimpleProduct milk = new SimpleProduct("Молоко", 80);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 160, 25);
        FixPriceProduct sugar = new FixPriceProduct("Сахар");

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

        SimpleProduct salat = new SimpleProduct("Салат", 60);

        basket.addProduct(salat);

        basket.clearBasket();

        basket.printContents();

        int emptyTotalCost = basket.getTotalCost();
        System.out.println("Стоимость пустой корзины: " + emptyTotalCost);

        boolean hasBananInEmptyBasket = basket.containsProductByName("Банан");
        System.out.println("Есть ли банан в пустой корзине? " + hasBananInEmptyBasket);

    }
}