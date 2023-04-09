package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginModel;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getParameter("url");
		String desc = request.getParameter("desc");
		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		int qty = Integer.parseInt(request.getParameter("qty"));
		double price = Double.parseDouble(request.getParameter("price"));

		new LoginModel().addProduct(url, desc, category, brand, model, qty, price);

		response.getWriter().print(true);
	}

}
