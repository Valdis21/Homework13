package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    public FixPriceProduct(String title) {
        super(title);
    }

    private static final int FIXED_PRICE = 90;

    public int getPrice() {
        return FIXED_PRICE;
    }

    public String toString() {
        return getTitle() + ": Фиксированная цена " + FIXED_PRICE;
    }

    public boolean isSpecial() {
        return true;
    }
}