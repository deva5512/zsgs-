package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginModel;

@WebServlet("/changeQtyInCart")
public class ChangeQtyInCart extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int no = Integer.parseInt(request.getParameter("no"));

		String mail = (String) request.getSession().getAttribute("mail");

		new LoginModel().changeCartQuantity(mail, id , no);
	}

}
