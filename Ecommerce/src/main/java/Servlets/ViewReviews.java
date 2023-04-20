package Servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginModel;

@WebServlet("/viewReviews")
public class ViewReviews extends HttpServlet {
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		response.getWriter().print(new LoginModel().getReview(id));
	}

}
