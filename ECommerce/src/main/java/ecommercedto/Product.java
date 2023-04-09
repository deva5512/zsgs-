package ecommercedto;

public class Product {
	
	private int id;
	private String url;
	private String description;
	private String catogory;
	private String brand_name;
	private String model;
	private int quantity;
	private double price;
	
	public Product(int id , String url , String descriptino , String catogory , String brand , String model , int qty , double price) {
		this.id = id;
		this.url = url;
		this.description = descriptino;
		this.catogory = catogory;
		this.brand_name = brand;
		this.model = model;
		this.quantity = qty;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	public String getCatogory() {
		return catogory;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public String getModel() {
		return model;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCatogory(String catogory) {
		this.catogory = catogory;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		System.out.println(id);
		System.out.println(url);
		return "";
	}

}
