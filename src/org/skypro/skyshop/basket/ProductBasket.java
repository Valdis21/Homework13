package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[5];
    private int count = 0;

    public ProductBasket() {
    }

    public void addProduct(Product product) {
        if (count >= products.length) {
            System.out.println("Невозможно добавить продукт: корзина переполнена.");
            return;
        }
        products[count++] = product;
    }

    public boolean containsProductByName(String name) {
        for (int i = 0; i < count; i++) {
            if (products[i].getTitle().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
    }

    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void printContents() {
        if (count == 0) {
            System.out.println("В корзине пусто");
        } else {
            int specialCount = 0;
            for (Product p : products) {
                System.out.println(p.toString());
                if (p.isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println("Итого " + getTotalCost());
            System.out.println("Специальных товаров " + specialCount);
        }
    }
}
