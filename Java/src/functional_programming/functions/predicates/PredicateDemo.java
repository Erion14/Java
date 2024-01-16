package functional_programming.functions.predicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
	
		public static void main(String[] args) {
			
			System.out.println("---Predicate Demo---");
			
			List<Product> products = new ArrayList<>(Arrays.asList(
					new DefaultProduct(1, "Product 1", "Category 1", 99.99 ),
					new DefaultProduct(2, "Product 2", "Category 2", 119.99 ),
					new DefaultProduct(3, "Product 3", "Category 3", 59.99 )));
			removeProductsIfPriceIsMoreThan(products, 100);
			
			for (Product product : products) {
				System.out.println(product);
			}
			
			System.out.println("---Predicate .and() demo---");
			
			removeProductsIfPriceIsMoreThanAndCategoryIsEqualTo(products, 90, "Category 1");
			
			for (Product product : products) {
				System.out.println(product);
			}
			System.out.println("---Predicate .isEqual() demo---");
			List<User> users = new ArrayList<>(Arrays.asList(
			        new UserForHashTables(1, "John", "Smith", "Password", "John@email.com"),
			        new UserForHashTables(2, "Ivan", "Smith", "password", "ivan@email.com"),
			        new UserForHashTables(3, "Erion", "Ademi", "password", "erion@email.com")
			));
			User criteriaUser = new UserForHashTables(3, "Erion", "Ademi", "password", "erion@email.com");

			users.removeIf(Predicate.not(Predicate.isEqual(criteriaUser)));
			System.out.println(users);

			
			
			
			
		}
		
		public static void removeProductsIfPriceIsMoreThan(List<? extends Product> products, double price) {
			products.removeIf(product -> product.getPrice()> price);
		}
		
		public static void removeProductsIfPriceIsMoreThanAndCategoryIsEqualTo(List<? extends Product> 
		products, double price, String categoryName) {
			Predicate<Product> isPriceIsMoreThanPredicate = product -> product.getPrice() > price;
			
			Predicate<Product> isCategoryIsEqualTo = product -> product.getCategoryName().equals(categoryName);
			
			products.removeIf(isPriceIsMoreThanPredicate.and(isCategoryIsEqualTo));
		}

}

class Product {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getCategoryName() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
class DefaultProduct extends Product {
    public DefaultProduct(int id, String name, String category, double price) {
        super(id, name, category, price);
    }
}

class User {
}

class UserForHashTables extends User {
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public UserForHashTables(int id, String firstName, String lastName, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserForHashTables{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
