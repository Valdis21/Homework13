package org.skypro.skyshop.product;

public abstract class Product {
    private String title;

    public Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract int getPrice();

    public String toString() {
        return getTitle() + " : " + getPrice();
    }

    public abstract boolean isSpecial();
}