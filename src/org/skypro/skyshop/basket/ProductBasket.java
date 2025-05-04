package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        String title = product.getTitle();
        List<Product> listOfProductsWithSameName = products.computeIfAbsent(title, k -> new ArrayList<>());
        listOfProductsWithSameName.add(product);
    }

    public boolean containsProductByName(String name) {
        return products.containsKey(name);
    }

    public void clearBasket() {
        products.clear();
    }

    public int getTotalCost() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printContents() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            int specialCount = 0;
            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    System.out.println(product.toString());
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                }
            }
            System.out.println("Итого " + getTotalCost());
            System.out.println("Специальных товаров " + specialCount);
        }
    }

    public List<Product> removeProductsByName(String name) {
        return products.remove(name);
    }
}