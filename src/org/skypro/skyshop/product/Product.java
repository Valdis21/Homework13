package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String title;

    public Product(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Имя товара не задано.");
        }
        this.title = title;
    }

    @Override
    public String getSearchTerm() {
        return title;
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Имя не задано.");
        }
        this.title = title;
    }

    public abstract int getPrice();

    public String toString() {
        return getTitle() + " : " + getPrice();
    }

    public abstract boolean isSpecial();
}