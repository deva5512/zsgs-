package validations;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;
import loginprocess.LoginModel;

@WebServlet("/verifylogin")
public class CheckUser extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		HttpSession session = request.getSession();

		if (name.isEmpty() || pass.isEmpty()) {
			response.sendRedirect("loginview.jsp");
			session.setAttribute("fail", "Invalid input");
			return;
		}

		User user = new LoginModel().checkForLogin(name, pass);
		if (user == null) {
			response.sendRedirect("loginview.jsp");
			session.setAttribute("fail", "Invalid user name or password");
		} else {
			if (user.getBalance() <= 0) {
				response.sendRedirect("SetAccountBalance.jsp");
			} else {
				response.sendRedirect("welcome.jsp");
			}
		}

	}
}
