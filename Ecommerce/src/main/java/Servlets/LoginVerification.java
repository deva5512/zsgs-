package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import login.LoginModel;

@WebServlet("/loginVerification")
public class LoginVerification extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		LoginModel model = new LoginModel();

		PrintWriter out = response.getWriter();
		int res = model.checkUserCredential(mail, pass);

		if (res == 200) {
			request.getSession().setAttribute("mail", mail);
		}

		out.print(res);
	}

}
