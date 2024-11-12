package model;

public class Customer {
    private int totalItemsPurchased;
    private double totalAmountSpent;

    // Updates the total items purchased and the total amount spent
    public void purchaseItem(double unitPrice, int quantity) {
        totalItemsPurchased += quantity;
        totalAmountSpent += unitPrice * quantity;
    }

    // Getters
    public int getTotalItemsPurchased() {
        return totalItemsPurchased;
    }

    public double getTotalAmountSpent() {
        return totalAmountSpent;
    }
}
