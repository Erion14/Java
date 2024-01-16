package functional_programming.functions.consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import functional_programming.Products.DefaultProduct;

public class ConsumerDemo {
	
	public static void main(String[] args) {
		System.out.println("--- Consumer Demo ---");
		
		List<DefaultProduct> products = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "Product 1", "Category 1", 99.99),
                new DefaultProduct(2, "Product 2", "Category 2", 149.99),
                new DefaultProduct(3, "Product 3", "Category 3", 39.99)
        ));
		
		
		
        for (DefaultProduct product : products) {
            System.out.println(product);
        }

}
}

