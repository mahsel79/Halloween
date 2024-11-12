package service;

import model.Customer;
import model.Product;
import model.DiscountedProduct;
import model.Wallet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopService {
    private Customer customer;
    private List<Product> products;
    private Wallet wallet;

    public ShopService(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
        this.wallet = new Wallet(500.00); // Initial wallet balance
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void startShopping() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nAvailable Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
            System.out.println((products.size() + 1) + ". Quit");

            System.out.print("Select a product to buy (1-" + (products.size() + 1) + "): ");
            int choice = scanner.nextInt();

            if (choice == products.size() + 1) {
                running = false;
                break;
            }

            System.out.print("Enter quantity to purchase: ");
            int quantity = scanner.nextInt();

            Product selectedProduct = products.get(choice - 1);
            double unitPrice = selectedProduct.getPrice();

            // Apply discount if it’s a DiscountedProduct
            if (selectedProduct instanceof DiscountedProduct) {
                unitPrice = ((DiscountedProduct) selectedProduct).getDiscountedPrice();
            }
            double totalCost = unitPrice * quantity;

            // Deduct from wallet, update product stock, and update customer’s purchase records
            try {
                wallet.deductAmount(totalCost);
                selectedProduct.purchase(quantity);
                customer.purchaseItem(unitPrice, quantity); // Using correct price, discounted if applicable
                System.out.println("Purchase successful! Remaining wallet balance: " + wallet.getBalance() + " SEK");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Display total purchased items and total amount spent
        System.out.println("\nTotal items purchased: " + customer.getTotalItemsPurchased());
        System.out.println("Total amount spent: " + customer.getTotalAmountSpent() + " SEK");
        System.out.println("Final wallet balance: " + wallet.getBalance() + " SEK");
    }
}
