package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginModel;

@WebServlet("/buyProduct")
public class BuyProduct extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			double amount = Double.parseDouble(request.getParameter("amount"));

			HttpSession session = request.getSession();
			String mail = (String) session.getAttribute("mail");

			LoginModel model = new LoginModel();
			response.getWriter().print(model.addOrder(amount, mail));
		} catch (Exception e) {
			response.getWriter().print(false);
		}

	}

}
