package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginModel;

@WebServlet("/addWishlist")
public class AddWishlist extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		HttpSession session = request.getSession();
		String mail = (String) session.getAttribute("mail");

		if (mail == null) {
			response.getWriter().print(-1);
		} else {	
			boolean res = new LoginModel().addWishList(id, mail);
			response.getWriter().print(res);
		}
	}

}
