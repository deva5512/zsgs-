package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ecommercedto.Cart;
import ecommercedto.Orders;
import ecommercedto.Product;
import ecommercedto.Review;
import ecommercedto.User;

public class ECommerceDb {

	private static ECommerceDb commerceDb;
	private Connection connection;

	private ECommerceDb() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ECOMMERCE", "root", "root123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ECommerceDb getInstance() {
		if (commerceDb == null) {
			commerceDb = new ECommerceDb();
		}
		return commerceDb;
	}

	public User checkUserCredential(String mail, String pass) {

		String query = "SELECT * FROM CUSTOMER WHERE MAIL_ID = ? AND PASS = ? ";
		PreparedStatement pst = null;
		User res = null;

		try {

			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setString(2, pass);

			ResultSet resultSet = pst.executeQuery();
			if (resultSet.next()) {

				String name = resultSet.getString("NAME");
				String mail_id = resultSet.getString("MAIL_ID");

				res = new User(mail_id, name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

//	public boolean loginStatus(String mail) {
//		String query = "SELECT * FROM CUSTOMER WHERE MAIL_ID = ? ";
//		PreparedStatement pst = null;
//
//		try {
//			pst = connection.prepareStatement(query);
//			pst.setString(1, mail);
//
//			ResultSet resultSet = pst.executeQuery();
//
//			resultSet.next();
//
//			boolean res = resultSet.getBoolean("LOGIN");
//
//			if (res) {
//				return false;
//			}
//
//			query = "UPDATE CUSTOMER SET LOGIN = true WHERE MAIL_ID = ?";
//
//			pst = connection.prepareStatement(query);
//			pst.setString(1, mail);
//
//			pst.execute();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return true;
//	}

	public boolean checkExistingUser(String mail) {
		String query = "SELECT * FROM CUSTOMER WHERE MAIL_ID = ? ";
		PreparedStatement pst = null;
		boolean res = false;

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);

			ResultSet resultSet = pst.executeQuery();

			res = resultSet.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void addUser(String name, String mail, String pass) {

//		String query = "INSERT INTO CUSTOMER VALUES ( ? , ? , ? ,?)";
		String query = "CALL ADD_CUSTOMER(? , ? , ?)";
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setString(2, name);
			pst.setString(3, pass);

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Product> searchProduct(String catogory, String brand, String model) {

		if (catogory == null || catogory.isEmpty()) {
			catogory = "+";
		}
		if (brand == null || brand.isEmpty()) {
			brand = "+";
		}
		if (model == null || model.isEmpty()) {
			model = "+";
		}

		List<Product> products = new LinkedList<>();

		String query = "SELECT * FROM PRODUCT WHERE CATOGORY LIKE ? OR BRAND_NAME LIKE ? OR MODEL LIKE ?";
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, "%" + catogory + "%");
			pst.setString(2, "%" + brand + "%");
			pst.setString(3, "%" + model + "%");

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				int id = Integer.parseInt(resultSet.getString("P_ID"));
				String url = resultSet.getString("URL");
				String description = resultSet.getString("DESCRIP");
				String catog = resultSet.getString("CATOGORY");
				String brand_name = resultSet.getString("BRAND_NAME");
				String model1 = resultSet.getString("MODEL");
				int quantity = Integer.parseInt(resultSet.getString("QUANTITY"));
				double price = Double.parseDouble(resultSet.getString("PRICE"));

				Product p = new Product(id, url, description, catog, brand_name, model1, quantity, price);
				products.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Orders> getOrders(String mail) {
		String query = "SELECT * FROM ORDERS WHERE MAIL_ID = ?";
		PreparedStatement pst = null;

		List<Orders> orders = new LinkedList<>();

		try {
			pst = connection.prepareStatement(query);

			pst.setString(1, mail);

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {

				String OrderDate = resultSet.getString("ORDER_DATE");
				double payment = resultSet.getDouble("PAYMENT");
				int order_id = resultSet.getInt("ORDER_ID");
				String address = resultSet.getString("ADDRESS");
				int pin = resultSet.getInt("PINCODE");
				long ph_no = resultSet.getLong("MOBILE_NUM");
				String d_date = resultSet.getString("DELIVERY_DATE");

				// get the orders for the particular order id and add it in the list
				List<Product> list = new ArrayList<>();
				query = "SELECT * FROM ORDER_LIST INNER JOIN PRODUCT ON PRODUCT.P_ID = ORDER_LIST.P_ID WHERE ORDER_ID = ?";
				pst = connection.prepareStatement(query);
				pst.setInt(1, order_id);
				ResultSet result = pst.executeQuery();

				while (result.next()) {

					int id = result.getInt("P_ID");
					String url = result.getString("URL");
					String description = result.getString("DESCRIP");
					String catog = result.getString("CATOGORY");
					String brand_name = result.getString("BRAND_NAME");
					String model1 = result.getString("MODEL");
					int quantity = result.getInt("LQUANTITY");
					double price = result.getDouble("PRICE");
					Product p = new Product(id, url, description, catog, brand_name, model1, quantity, price);

					list.add(p);
				}

				Orders o = new Orders(list, OrderDate, payment, order_id, address, ph_no, pin, d_date);
				orders.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	public List<Cart> getCart(String mail) {
		String query = "SELECT * FROM CART INNER JOIN PRODUCT ON PRODUCT.P_ID = CART.P_ID WHERE MAIL_ID = ? ";
		PreparedStatement pst = null;
		List<Cart> cart = new LinkedList<>();

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("P_ID");
				String url = resultSet.getString("URL");
				String description = resultSet.getString("DESCRIP");
				String catog = resultSet.getString("CATOGORY");
				String brand_name = resultSet.getString("BRAND_NAME");
				String model1 = resultSet.getString("MODEL");
				int quantity = resultSet.getInt("QUANTITY");
				double price = resultSet.getDouble("PRICE");

				Product p = new Product(id, url, description, catog, brand_name, model1, quantity, price);

				int qty = resultSet.getInt("CQUANTITY");
				int cart_id = resultSet.getInt("CART_ID");

				Cart c = new Cart(p, qty, cart_id);
				cart.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	public List<Product> getWishlist(String mail) {

		String query = "SELECT * FROM PRODUCT WHERE P_ID IN (SELECT P_ID FROM WISHLIST WHERE MAIL_ID = ?)";
		PreparedStatement pst = null;
		List<Product> products = new LinkedList<>();

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("P_ID");
				String url = resultSet.getString("URL");
				String description = resultSet.getString("DESCRIP");
				String catog = resultSet.getString("CATOGORY");
				String brand_name = resultSet.getString("BRAND_NAME");
				String model1 = resultSet.getString("MODEL");
				int quantity = resultSet.getInt("QUANTITY");
				double price = resultSet.getDouble("PRICE");

				Product p = new Product(id, url, description, catog, brand_name, model1, quantity, price);

				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public void addToWishList(String mail, int p_id) {
		String query = "INSERT INTO WISHLIST VALUES (? , ?)";

		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setInt(2, p_id);

			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean checkWishList(String mail, int p_id) {
		// SELECT * FROM WISHLIST WHERE MAIL_ID ='devendran5512@gmail.com' AND P_ID = 2
		String query = " SELECT * FROM WISHLIST WHERE MAIL_ID = ? AND P_ID = ?";
		boolean res = false;

		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setInt(2, p_id);

			ResultSet resultSet = pst.executeQuery();
			res = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void addToCart(String mail, int p_id, int quantity) {
		String query = "CALL ADD_CART(? , ? , ?);";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setInt(2, p_id);
			pst.setInt(3, quantity);

			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addToOrder(String mail, double payment) {
		List<Cart> list = getCart(mail);

		String query = "CALL ADD_ORDER(?, ?)";
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(query);

			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setDouble(2, payment);

			pst.execute();

			for (int i = 0; i < list.size(); i++) {

				Cart c = list.get(i);

				query = "CALL MODIFYQUANTITY(? , ?)";
				pst = connection.prepareStatement(query);
				pst.setInt(1, c.getQuantity());
				pst.setInt(2, c.getProduct().getId());

				pst.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addProduct(String url, String desc, String catogory, String brand, String model, int qty,
			double price) {
		// URL , DESCRIP , CATOGORY , BRAND_NAME , MODEL , QUANTITY , PRICE
		String query = "CALL ADD_PRODUCT( ? , ? , ? , ? , ? , ? , ?);";

		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, url);
			pst.setString(2, desc);
			pst.setString(3, catogory);
			pst.setString(4, brand);
			pst.setString(5, model);
			pst.setInt(6, qty);
			pst.setDouble(7, price);

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getQuantity(int p_id) {
		String query = "SELECT QUANTITY FROM PRODUCT WHERE P_ID = ?";
		PreparedStatement pst = null;
		int res = 0;

		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, p_id);

			ResultSet resultSet = pst.executeQuery();

			resultSet.next();

			res = resultSet.getInt("QUANTITY");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void removeWishList(String mail, int id) {
		String query = "DELETE FROM WISHLIST WHERE P_ID = ? AND MAIL_ID = ?";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, mail);

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeCart(int id) {

		String query = "DELETE FROM CART WHERE CART_ID = ?";
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeOrder(int id) {

		// DELETE FROM ORDER_LIST WHERE ORDER_ID = 6;

		// DELETE FROM ORDERS WHERE ORDER_ID = 6;
		increaseProductCount(id);

		String query = "DELETE FROM ORDER_LIST WHERE ORDER_ID = ?";

		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);

			pst.execute();

			query = "DELETE FROM ORDERS WHERE ORDER_ID = ?";

			pst = connection.prepareStatement(query);
			pst.setInt(1, id);

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void increaseProductCount(int id) {
		// SELECT * FROM ORDER_LIST WHERE ORDER_ID = 2;
		String query = "SELECT P_ID , LQUANTITY FROM ORDER_LIST WHERE ORDER_ID = ?";

		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				query = "CALL MODIFYQUANTITY( ? , ?)";

				pst = connection.prepareStatement(query);
				pst.setInt(1, -1 * resultSet.getInt("LQUANTITY"));
				pst.setInt(2, resultSet.getInt("P_ID"));

				pst.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addReview(String mail, int p_id, String message) {
		// CALL ADDREVIEW('devendran5512@gmail.com' , 2 , 'goodproducr');
		String query = "CALL ADDREVIEW(? , ? , ?);";
		PreparedStatement pst = null;
		try {

			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setInt(2, p_id);
			pst.setString(3, message);

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Review> getReview(int p_id) {
		// select * from REVIEW where P_ID = 2
		String query = "select * from REVIEW where P_ID = ?";
		List<Review> list = new LinkedList<>();
		PreparedStatement pst = null;
		try {

			pst = connection.prepareStatement(query);
			pst.setInt(1, p_id);

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("NAME");
				String message = resultSet.getString("MESSAGE");
				String date = resultSet.getString("R_DATE") + "";

				Review r = new Review(name, message, date);

				list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void removeReview(String mail, int id) {
		// DELETE FROM REVIEW WHERE MAIL_ID = 'devendran5512@gmail.com' AND P_ID = 2;
		String query = "DELETE FROM REVIEW WHERE MAIL_ID = ? AND P_ID = ?";
		PreparedStatement pst = null;

		try {

			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setInt(2, id);

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int[] getNotificationCount(String mail) {
		int[] arr = new int[3];

		String query = "CALL QUANTITY(?)";
		PreparedStatement pst = null;

		try {

			pst = connection.prepareStatement(query);
			pst.setString(1, mail);

			ResultSet resultSet = pst.executeQuery();

			if (resultSet.next()) {
				String res = resultSet.getString("QTY");
				String[] s = res.split(" ");
				arr[0] = Integer.parseInt(s[0]);
				arr[1] = Integer.parseInt(s[1]);
				arr[2] = Integer.parseInt(s[2]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

//	public void logout(String mail) {
//		String query = "UPDATE CUSTOMER SET LOGIN = false WHERE MAIL_ID = ?";
//		PreparedStatement pst = null;
//
//		try {
//
//			pst = connection.prepareStatement(query);
//			pst.setString(1, mail);
//
//			pst.execute();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public boolean checkExistingAddress(String mail) {
		String query = "SELECT * FROM CUSTOMER WHERE MAIL_ID = ?";
		PreparedStatement pst = null;
		String address = null;

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);

			ResultSet resultSet = pst.executeQuery();

			if (resultSet.next()) {
				address = resultSet.getString("ADDRESS");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return address != null;
	}

	public void updateDeliveryAddress(String mail, String address, long mobile, int pin) {
		String query = "UPDATE CUSTOMER SET MOBILE_NUM = ? , ADDRESS = ? , PINCODE = ? WHERE MAIL_ID = ?";
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(query);
			pst.setLong(1, mobile);
			pst.setString(2, address);
			pst.setInt(3, pin);
			pst.setString(4, mail);

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean increaseCount(int id, int count) {
		String query = "SELECT * FROM PRODUCT WHERE P_ID = ? ";
		PreparedStatement pst = null;
		boolean res = false;

		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);

			ResultSet resultSet = pst.executeQuery();

			res = resultSet.next();

			if (res) {
				query = "UPDATE PRODUCT SET QUANTITY = ? WHERE P_ID = ? ";

				pst = connection.prepareStatement(query);
				pst.setInt(1, count);
				pst.setInt(2, id);

				pst.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void changeCartQuantity(String mail, int id, int no) {
		String query = "CALL UPDATE_CART_QTY ( ? , ? ,?)";
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setInt(2, id);
			pst.setInt(3, no);

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int checkAlredyExistInCart(int p_id, String mail) {
		String query = "SELECT CQUANTITY FROM CART WHERE MAIL_ID = ? AND P_ID = ?";
		PreparedStatement pst = null;
		int res = 0;

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setInt(2, p_id);

			ResultSet resultSet = pst.executeQuery();

			if (resultSet.next()) {
				res = resultSet.getInt("CQUANTITY");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public int getCartid(String mail, int p_id) {
		String query = "SELECT * FROM CART WHERE MAIL_ID = ? AND P_ID = ?";
		PreparedStatement pst = null;
		int res = 0;

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, mail);
			pst.setInt(2, p_id);

			ResultSet resultSet = pst.executeQuery();

			resultSet.next();
			res = resultSet.getInt("CART_ID");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
