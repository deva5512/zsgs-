package ecommercedto;

import java.util.List;

public class Orders {

	private List<Product> product;
	private String OrderDate;
	private double payment;
	private int order_id;
	private String address;
	private int pin;
	private long phno;
	private String d_date;

	public Orders(List<Product> product, String orderDate, double payment, int order_id, String address,
			long phno, int pin, String d_date) {
		this.product = product;
		this.OrderDate = orderDate;
		this.payment = payment;
		this.order_id = order_id;
		this.address = address;
		this.phno = phno;
		this.pin = pin;
		this.d_date = d_date;

	}

	public List<Product> getProduct() {
		return product;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public double getPayment() {
		return payment;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String toString() {
		System.out.println(product);
		System.out.println(OrderDate);
		return "";
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getAddress() {
		return address;
	}

	public int getPin() {
		return pin;
	}

	public long getPhno() {
		return phno;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public String getD_date() {
		return d_date;
	}

	public void setD_date(String d_date) {
		this.d_date = d_date;
	}

	@Override
	public int hashCode() {
		return order_id;
	}
}
