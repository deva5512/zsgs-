package login;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

import ecommercedto.Cart;
import ecommercedto.Orders;
import ecommercedto.Product;
import ecommercedto.Review;
import ecommercedto.User;
import repository.ECommerceDb;

public class LoginModel {

	public int checkUserCredential(String mail, String pass) {
		User user = ECommerceDb.getInstance().checkUserCredential(mail, pass);

		if (user == null) {
			return 500;
		}
		return 200;
	}

	public boolean newUserRegistration(String name, String mail, String pass) {
		if (ECommerceDb.getInstance().checkExistingUser(mail)) {
			return false;
		}

		ECommerceDb.getInstance().addUser(name, mail, pass);
		return true;
	}

	public JSONArray getProducts(String catogory, String brand, String model) {
		List<Product> products = ECommerceDb.getInstance().searchProduct(catogory, brand, model);

		if (products.size() == 0) {
			return null;
		}

		JSONArray array = new JSONArray();

		for (Product p : products) {

			JSONObject obj = createObj(p);

			array.add(obj);
		}

		return array;
	}

	public JSONArray getOrders(String mail) {
		List<Orders> orders = ECommerceDb.getInstance().getOrders(mail);

		if (orders.size() == 0) {
			return null;
		}

		JSONArray array = new JSONArray();

		for (Orders o : orders) {

			JSONObject obj = new JSONObject();

			List<Product> list = o.getProduct();

			JSONArray arr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				arr.add(createObj(list.get(i)));
			}

			obj.put("Products", arr);
			obj.put("payment", o.getPayment());
			obj.put("date", o.getOrderDate());
			obj.put("delivery_date", o.getD_date());
			obj.put("orderid", o.getOrder_id());
			obj.put("address", o.getAddress());
			obj.put("mobile_no", o.getPhno());
			obj.put("pincode", o.getPin());

			LocalDate current_date = LocalDate.now();
			LocalDate delivery_date = LocalDate.parse(o.getD_date());
			long days = current_date.until(delivery_date, ChronoUnit.DAYS);

			if (days >= 0) {
				obj.put("cancelation", true);
			} else {
				obj.put("cancelation", false);
			}

			array.add(obj);
		}

		return array;
	}

	public JSONArray getWishList(String mail) {
		List<Product> products = ECommerceDb.getInstance().getWishlist(mail);

		if (products.size() == 0) {
			return null;
		}

		JSONArray array = new JSONArray();

		for (Product p : products) {

			JSONObject obj = createObj(p);

			array.add(obj);
		}

		return array;

	}

	public JSONArray getCart(String mail) {
		List<Cart> cart = ECommerceDb.getInstance().getCart(mail);

		if (cart.size() == 0) {
			return null;
		}
		JSONArray array = new JSONArray();

		for (Cart c : cart) {

			JSONObject obj = createObj(c.getProduct());

			obj.put("cart_quantity", c.getQuantity());
			obj.put("cart_id", c.getCart_id());

			array.add(obj);
		}

		return array;
	}

	private JSONObject createObj(Product product) {
		JSONObject obj = new JSONObject();

		obj.put("id", product.getId());
		obj.put("url", product.getUrl());
		obj.put("description", product.getDescription());
		obj.put("catogory", product.getCatogory());
		obj.put("brandName", product.getBrand_name());
		obj.put("model", product.getModel());
		obj.put("productQuantity", product.getQuantity());
		obj.put("price", product.getPrice());

		return obj;
	}

	public boolean addWishList(int p_id, String mail) {
		if (ECommerceDb.getInstance().checkWishList(mail, p_id)) {
			return false;
		}
		ECommerceDb.getInstance().addToWishList(mail, p_id);
		return true;
	}

	public int addCart(int p_id, int quantity, String mail) {

		int check_alredy_exist = ECommerceDb.getInstance().checkAlredyExistInCart(p_id, mail);

		int qty = ECommerceDb.getInstance().getQuantity(p_id) - check_alredy_exist;

		if (qty < quantity)
			return 0;

		if (check_alredy_exist == 0) {
			ECommerceDb.getInstance().addToCart(mail, p_id, quantity);
			return 1;
		} else {
			if (quantity + check_alredy_exist > 10) {
				return 0;
			}
			int cart_id = ECommerceDb.getInstance().getCartid(mail, p_id);
			ECommerceDb.getInstance().changeCartQuantity(mail, cart_id, quantity);
			return 2;
		}
	}

	public double getTotal(String mail) {
		List<Cart> cart = ECommerceDb.getInstance().getCart(mail);

		double sum = 0;

		for (int i = 0; i < cart.size(); i++) {
			Cart c = cart.get(i);
			sum += c.getQuantity() * c.getProduct().getPrice();
		}
		return sum;
	}

	public boolean addOrder(double payment, String mail) {
		boolean check_quantity_availablity = CheckAvailabilityForOrder(mail);

		if (!check_quantity_availablity) {
			return false;
		}

		ECommerceDb.getInstance().addToOrder(mail, payment);
		return true;
	}

	private boolean CheckAvailabilityForOrder(String mail) {
		List<Cart> list = ECommerceDb.getInstance().getCart(mail);

		for (int i = 0; i < list.size(); i++) {
			Cart c = list.get(i);
			if (c.getQuantity() > c.getProduct().getQuantity()) {
				return false;
			}
		}
		return true;
	}

	public void addProduct(String url, String desc, String catogory, String brand, String model, int qty,
			double price) {
		ECommerceDb.getInstance().addProduct(url, desc, catogory, brand, model, qty, price);
	}

	public void removeWishList(int id, String mail) {
		ECommerceDb.getInstance().removeWishList(mail, id);
	}

	public void removeCart(int id) {
		ECommerceDb.getInstance().removeCart(id);
	}

	public void removeOrder(int o_id) {
		ECommerceDb.getInstance().removeOrder(o_id);
	}

	public JSONArray getNotificationCount(String mail) {
		int[] count = ECommerceDb.getInstance().getNotificationCount(mail);
		JSONArray arr = new JSONArray();
		arr.add(count[0]);
		arr.add(count[1]);
		arr.add(count[2]);
		return arr;
	}

//	public void logout(String mail) {
//		ECommerceDb.getInstance().logout(mail);
//	}

	// to add review
	public void addReview(int p_id, String message, String mail) {
		ECommerceDb.getInstance().addReview(mail, p_id, message);
	}

	// to get review
	public JSONArray getReview(int id) {
		List<Review> cart = ECommerceDb.getInstance().getReview(id);

		if (cart.size() == 0) {
			return null;
		}
		JSONArray array = new JSONArray();

		for (Review r : cart) {

			JSONObject obj = new JSONObject();

			obj.put("name", r.getName());
			obj.put("message", r.getMessage());
			obj.put("date", r.getDate());

			array.add(obj);
		}

		return array;
	}

	// tp remove review
	public void removeReview(int id, String mail) {
		ECommerceDb.getInstance().removeReview(mail, id);
	}

	public boolean checkExistingAddress(String mail) {
		return ECommerceDb.getInstance().checkExistingAddress(mail);
	}

	public void updateDeliveryAddress(String mail, String address, long mobile, int pin) {
		ECommerceDb.getInstance().updateDeliveryAddress(mail, address, mobile, pin);
	}

	public boolean increaseCount(int id, int count) {
		return ECommerceDb.getInstance().increaseCount(id, count);
	}

	public void changeCartQuantity(String mail, int id, int no) {
		ECommerceDb.getInstance().changeCartQuantity(mail, id, no);
	}

}
