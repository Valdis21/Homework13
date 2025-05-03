package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String title, int price) {
        super(title);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена товара не может быть меньше нуля.");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена товара не может быть меньше нуля.");
        }
        this.price = price;
    }

    public boolean isSpecial() {
        return false;
    }
}

