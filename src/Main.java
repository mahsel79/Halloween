import model.Customer;
import model.Product;
import model.DiscountedProduct;
import service.ShopService;

public class Main {
    public static void main(String[] args) {

        // Create a customer and initialize the shop service
        Customer customer = new Customer();
        ShopService shopService = new ShopService(customer);

        // Add products to the shop
        shopService.addProduct(new Product("Mask", 100.00, 10));
        shopService.addProduct(new Product("Plastic Knife", 75.00, 25));
        shopService.addProduct(new Product("Fake Blood", 50.00, 20));
        shopService.addProduct(new Product("Halloween Tattoos", 25.00, 50));
        shopService.addProduct(new DiscountedProduct("Halloween Costume", 150.00, 5, 0.10)); // 10% Discount

        // Start shopping service
        shopService.startShopping();

    }
}