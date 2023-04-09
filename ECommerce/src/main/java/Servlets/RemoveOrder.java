package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginModel;

@WebServlet("/removeOrder")
public class RemoveOrder extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int o_id = Integer.parseInt(request.getParameter("id"));

		new LoginModel().removeOrder(o_id);
	}

}
