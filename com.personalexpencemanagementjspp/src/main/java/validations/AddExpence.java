package validations;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Expence;
import loginprocess.LoginModel;

@WebServlet("/addExpence")
public class AddExpence extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String num = request.getParameter("amount");

		HttpSession session = request.getSession();
		if (num.isEmpty()) {
			response.sendRedirect("welcome.jsp");
			session.setAttribute("status", "empty");
			return;
		} else {
			double amount = Double.parseDouble(num);
			String reason = request.getParameter("reason");

			if (amount <= 0) {
				response.sendRedirect("welcome.jsp");
				session.setAttribute("status", "empty");
				return;
			}

			Expence expence = new Expence(amount, reason);

			boolean res = new LoginModel().addExpence(expence);

			if (!res) {
				session.setAttribute("status", "failed");
			} else {
				if (LoginModel.user.getAllowedonedayamount() < LoginModel.user.getTodayspending()) {
					session.setAttribute("status", "warning");
				} else {
					session.setAttribute("status", "success");
				}
			}
			response.sendRedirect("welcome.jsp");
		}
	}
}
