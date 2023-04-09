package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

import login.LoginModel;

/**
 * Servlet implementation class GetNotification
 */
@WebServlet("/getNotification")
public class GetNotification extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginModel model = new LoginModel();
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String mail = (String) session.getAttribute("mail");

		JSONArray array = model.getNotificationCount(mail);
		out.print(array);
	}

}
