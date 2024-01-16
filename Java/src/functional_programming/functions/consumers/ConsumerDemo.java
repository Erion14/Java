package functional_programming.functions.consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import functional_programming.Products.DefaultProduct;
import functional_programming.Products.Product;

public class ConsumerDemo {
	
	public static void main(String[] args) {
		System.out.println("--- Consumer Demo ---");
		
		List<DefaultProduct> products = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "Product 1", "Category 1", 99.99),
                new DefaultProduct(2, "Product 2", "Category 2", 149.99),
                new DefaultProduct(3, "Product 3", "Category 3", 39.99)
        ));
		
		
		increasePriceForProductList(products, 10);
        for (DefaultProduct product : products) {
            System.out.println(product);
        }
        
        System.out.println("---BiConsumer Demo---");
        Map<Integer, DefaultProduct> idProducMap = new HashMap<>();
        idProducMap.put(1, new DefaultProduct(1, "Product 1", "Category 1", 99.99));
        idProducMap.put(2, new DefaultProduct(2, "Product 2", "Category 2", 149.99));
        idProducMap.put(3, new DefaultProduct(3, "Product 3", "Category 3", 39.99));
        
        increasePriceForProductMap(idProducMap, 20);
        for (DefaultProduct defaultProduct : idProducMap.values()) {
        	System.out.println(defaultProduct);
			
		}


}
	public static void increasePriceForProductList(List<? extends DefaultProduct> products, double priceToIncrease) {
		products.iterator().forEachRemaining(product -> product.setPrice(product.getPrice()+ priceToIncrease));
	}
	public static void increasePriceForProductMap(Map<Integer, ? extends DefaultProduct> 
																	idProductMap, double priceToIncrease) {
		idProductMap.forEach((id, product) -> product.setPrice(product.getPrice()+priceToIncrease));
	}
}

