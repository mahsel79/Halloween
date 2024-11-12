package model;

public class DiscountedProduct extends Product {
    private double discountRate;

    public DiscountedProduct(String name, double price, int stock, double discountRate) {
        super(name, price, stock);
        this.discountRate = discountRate;
    }

    // Calculate the discounted price accurately
    public double getDiscountedPrice() {
        return getPrice() * (1 - discountRate);
    }

    @Override
    public String toString() {
        return getName() + " - Original Price: " + getPrice() + " SEK (Discounted Price: " + getDiscountedPrice() + " SEK, Stock: " + getStock() + ")";
    }
}
