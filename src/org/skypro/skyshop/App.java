package org.skypro.skyshop.app;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        ProductBasket basket = new ProductBasket();

        SimpleProduct banan = null;
        SimpleProduct apple = null;
        SimpleProduct milk = null;
        DiscountedProduct meat = null;
        FixPriceProduct sugar = null;

        try {
            banan = new SimpleProduct("Банан", 120);
            apple = new SimpleProduct("Яблоко", 150);
            milk = new SimpleProduct("Молоко", 80);
            meat = new DiscountedProduct("Мясо", 160, 25);
            sugar = new FixPriceProduct("Сахар");

            SimpleProduct chocolate = new SimpleProduct("Шоколад", 0);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            DiscountedProduct grape = new DiscountedProduct("Виноград", 150, 180);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        basket.addProduct(banan);
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(meat);
        basket.addProduct(sugar);

        basket.printContents();

        List<Product> deletedProducts = basket.removeProductsByName("Молоко");
        if (!deletedProducts.isEmpty()) {
            System.out.println("Был удален товар");
            for (Product p : deletedProducts) {
                System.out.println(p.getTitle());
            }
        }else {
            System.out.println("Нет товаров для удаления");
        }

        basket.printContents();

        deletedProducts = basket.removeProductsByName("Апельсин");
        if (deletedProducts.isEmpty()) {
            System.out.println("Спиcок удаленных продуктов пуст.");
        }

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

        SearchEngine engine = new SearchEngine(8);

        Article articleBanan = new Article("В чем польза банана", "5 полезных свойств банана");
        Article articleApple = new Article("Сорта яблока", "Новые сорта яблок");
        Article articleMilk = new Article("Полезно ли молоко?", "В чем польза употребления молока?");

        engine.add(banan);
        engine.add(apple);
        engine.add(milk);
        engine.add(articleBanan);
        engine.add(articleApple);
        engine.add(articleMilk);

        try {
            Searchable result = engine.bestMatch("Банан");
            System.out.println("Поиск выполнен успешно: " + result.getName() + " найден.");
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable result = engine.bestMatch("Ананас");
            System.out.println("Поиск выполнен успешно: " + result.getName() + " найден.");
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        testSearch(engine, "Банан");
        testSearch(engine, "Яблоко");
        testSearch(engine, "Молоко");
    }

    private static void testSearch(SearchEngine engine, String query) {
        System.out.println("\n === Поиск по запросу " + query + " ===");
        Searchable[] results = engine.search(query);
        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }
}