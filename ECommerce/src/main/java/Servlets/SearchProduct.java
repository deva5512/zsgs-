package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import login.LoginModel;

@WebServlet("/searchProduct")
public class SearchProduct extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product = request.getParameter("product");

		LoginModel model = new LoginModel();
		JSONArray array = model.getProducts(product, product, product);
		
		response.getWriter().print(array);
	}

}
