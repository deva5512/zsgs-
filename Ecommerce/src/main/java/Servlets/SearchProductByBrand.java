package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import login.LoginModel;

@WebServlet("/searchProductByBrand")
public class SearchProductByBrand extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product = request.getParameter("product");

		int sortOrder = Integer.parseInt(request.getParameter("sort"));

		LoginModel model = new LoginModel();
		JSONArray array = model.getProductByBrand(product, sortOrder);

		response.getWriter().print(array);
		
		

	}

}
