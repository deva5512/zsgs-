package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginModel;

@WebServlet("/viewCart")
public class ViewCart extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		String mail = (String) session.getAttribute("mail");
		
		if (mail == null) {
			out.print(false);
			return;
		}
		LoginModel model = new LoginModel();
		out.print(model.getCart(mail));
	}

}
