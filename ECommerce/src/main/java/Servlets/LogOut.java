package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginModel;

@WebServlet("/logOut")
public class LogOut extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String mail = (String) request.getSession().getAttribute("mail");
//		new LoginModel().logout(mail);
		request.getSession().invalidate();
	}

}
