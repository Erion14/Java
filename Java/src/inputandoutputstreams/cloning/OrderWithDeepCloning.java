package inputandoutputstreams.cloning;

import java.util.ArrayList;
import java.util.List;

import functional_programming.Products.Product;

public class OrderWithDeepCloning {
	
	private String creditCardNumber;
	private List<Product> products;
	private int customId;
	
	
	
	
	public Object clone() throws CloneNotSupportedException{
		OrderWithDeepCloning cloneOrder = (OrderWithDeepCloning) super.clone();
		
		List<Product> productsCopy = new ArrayList<>(this.products);
		cloneOrder.setProducts(productsCopy);
		
		return cloneOrder;
	}
	
	
	@Override
	public String toString() {
		return "OrderWithDeepCloning [creditCardNumber=" + creditCardNumber + ", products=" + products + ", customId="
				+ customId + "]";
	}
	public OrderWithDeepCloning(String creditCardNumber, List<Product> products, int customId) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.products = products;
		this.customId = customId;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getCustomId() {
		return customId;
	}
	public void setCustomId(int customId) {
		this.customId = customId;
	}
	
	
	

}
