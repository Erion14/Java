package functional_programming.Products;

public class  Product{
	private int id;
	private double price;
	
	
	
	
	public Product(int id, double price) {
		super();
		this.id = id;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

