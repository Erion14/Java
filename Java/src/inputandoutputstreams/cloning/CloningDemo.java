package inputandoutputstreams.cloning;

import java.util.ArrayList;
import java.util.List;

import functional_programming.Products.Product;

public class CloningDemo {
	
	public static void main(String[] args) throws CloneNotSupportedException {
        // Simulating product data without ProductManagementService
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product1", 20.0));
        products.add(new Product("Product2", 30.0));
        products.add(new Product("Product3", 15.0));

        User user = new User();

        Order order = new Order("1234123412341234", products, 1);
        System.out.println("Original order: " + order);

        Order clonedOrder = (Order) order.clone();
        System.out.println("Cloned order: " + clonedOrder);

        clonedOrder.getProducts().clear();
        System.out.println("*** Cleared products for cloned order object ***");

        System.out.println("Original order: " + order);

        System.out.println("===== Deep cloning demo =====");
        // Simulating product data without ProductManagementService
        List<Product> newProducts = new ArrayList<>();
        newProducts.add(new Product("Product4", 25.0));
        newProducts.add(new Product("Product5", 40.0));
        newProducts.add(new Product("Product6", 18.0));

        OrderWithDeepCloning order1 = new OrderWithDeepCloning("1234123412341234", newProducts, 1);

        var order2 = (OrderWithDeepCloning) order1.clone();
        order2.getProducts().clear();

        System.out.println("Original order: " + order1);
        System.out.println("Cloned order: " + order2);
    }
}
