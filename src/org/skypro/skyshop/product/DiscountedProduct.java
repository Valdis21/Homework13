package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String title, int basePrice, int discountPrice) {
        super(title);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена не может быть меньше нуля.");
        }
        this.basePrice = basePrice;

        if (discountPrice <= 0 || discountPrice >= 100) {
            throw new IllegalArgumentException("Процент скидки должен быть больше или равен 0 и/или меньше или равен 100.");
        }
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
