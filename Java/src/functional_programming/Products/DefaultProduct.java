package functional_programming.Products;

public class DefaultProduct{
	private int id;
	private String name;
	private String category;
	private double price;
	
	
	
	
	@Override
	public String toString() {
		return "DefaultProduct [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	}
	public DefaultProduct(int id, String name, String category, double price) {
	
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}

