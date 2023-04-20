package ecommercedto;

public class Cart {

	private Product product;
	private int quantity;
	private int cart_id;

	public Cart(Product product, int qty, int cart_id) {
		this.product = product;
		this.quantity = qty;
		this.setCart_id(cart_id);
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		System.out.println(product);
		System.out.println(quantity);
		return "";
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
}
