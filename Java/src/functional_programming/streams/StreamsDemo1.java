package functional_programming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDemo1 {
	public static void main(String[] args) {
		System.out.println("--- filter() and map() and collect() demo ---");
		List<Product> products = new ArrayList<>(Arrays.asList(
				new Product("Iphone", 1109.99, 2031),
				new Product("Llaptop", 799.99, 810),
				new Product("Table", 399.99, 1854),
				new Product("Sony Playstation", 2009.99, 1002),
				new Product("Bags", 49.99, 20000)));
		
		List<Product> modifiedProducts = products.stream()
				.filter(product -> product.getItemsInWarehouse() > 1000)
				.map(product -> {
					product.setPrice(product.getPrice() - (product.getPrice() * 0.1));
					return product;
				})
				.collect(Collectors.toList());
		
		modifiedProducts.stream().forEach(System.out::println);
	
		System.out.println("---flatmap() demo---");
		
		Warehouse warehouse1 = new Warehouse();
		Warehouse warehouse2 = new Warehouse();
		Warehouse warehouse3 = new Warehouse();
		
		warehouse1.setProducts(Arrays.asList(new Product("Iphone", 1109.99, 2031),
							new Product("Llaptop", 699.99, 23)));
		warehouse2.setProducts(Arrays.asList(new Product("Bags", 49.99, 600)));
		warehouse3.setProducts(Arrays.asList(new Product("Sony Playstation", 2009.99, 133),
				new Product("Table", 499.99, 1343)));
		
		List<Warehouse> warehouses = new ArrayList<>(Arrays.asList(
				warehouse1,
				warehouse2,
				warehouse3  ));
		
		Product[] productsArray = warehouses.stream()
				.flatMap(warehouse -> warehouse.getProducts().stream())
				.filter(product -> product.getItemsInWarehouse() > 1000)
				.map(product -> {
					product.setPrice(product.getPrice() - (product.getPrice() * 0.1));
					return product;
				})
				.toArray(Product[]::new);
		
		Arrays.stream(productsArray).forEach(System.out::println);
					

		System.out.println("--- toMap() demo ---");
		Map<String, Product> productMap = products.stream()
				.collect(Collectors.toMap(Product::getName, Function.identity()));
		
		System.out.println(productMap);
		
		System.out.println("--- mapToInt() & sum() demo ---");
		
		int totalItemsAmount = products.stream()
				.mapToInt(product -> product.getItemsInWarehouse())
				.sum();
		System.out.println("Items in warehouse: " + totalItemsAmount);
		
	}

}

class Product{
	private String name;
	private double price;
	private int itemsInWarehouse;
	
	public Product(String name, double price, int itemsInWarehouse) {
		super();
		this.name = name;
		this.price = price;
		this.itemsInWarehouse = itemsInWarehouse;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", itemsInWarehouse=" + itemsInWarehouse + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getItemsInWarehouse() {
		return itemsInWarehouse;
	}
	public void setItemsInWarehouse(int itemsInWarehouse) {
		this.itemsInWarehouse = itemsInWarehouse;
	}
		
}



class Warehouse {
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}