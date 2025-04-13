package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String title, int basePrice, int discountPrice) {
        super(title);
        this.basePrice = basePrice;
        this.discountPercent = discountPrice;
    }

    public int getPrice() {
        double discountPrice = basePrice * (1 - ((double) discountPercent / 100));
        return (int) Math.round(discountPrice);
    }

    public String toString() {
        return getTitle() + " : " + getPrice() + " (" + discountPercent + "%)";
    }

    public boolean isSpecial() {
        return true;
    }
}
