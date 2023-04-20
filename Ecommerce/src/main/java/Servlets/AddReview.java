package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginModel;

/**
 * Servlet implementation class AddReview
 */
@WebServlet("/addReview")
public class AddReview extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String message = request.getParameter("review");

		String mail = (String) request.getSession().getAttribute("mail");

		LoginModel model = new LoginModel();

		model.addReview(id, message, mail);

	}

}
