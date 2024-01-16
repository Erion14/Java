package functional_programming.functions.predicates;

public class PredicateDemo {

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
