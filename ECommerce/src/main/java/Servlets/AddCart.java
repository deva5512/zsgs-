package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import login.LoginModel;

@WebServlet("/addCart")
public class AddCart extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int qty = Integer.parseInt(request.getParameter("qty"));

			HttpSession session = request.getSession();
			String mail = (String) session.getAttribute("mail");

			if (mail == null) {
				response.getWriter().print(-1);
			} else {
				int res = new LoginModel().addCart(id, qty, mail);
				response.getWriter().print(res);
			}
		} catch (Exception e) {
			response.getWriter().print(0);
		}
	}

}
