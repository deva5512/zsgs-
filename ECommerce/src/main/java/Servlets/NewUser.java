package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginModel;

/**
 * Servlet implementation class LoginVerification
 */
@WebServlet("/newUser")
public class NewUser extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		
		LoginModel model = new LoginModel();
		boolean res = model.newUserRegistration(name, mail, pass);
		if(res) {
			request.getSession().setAttribute("mail", mail);
		}
		response.getWriter().print(res);
	}

}
