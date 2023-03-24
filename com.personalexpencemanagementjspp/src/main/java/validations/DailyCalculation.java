package validations;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginprocess.LoginModel;

@WebServlet("/calculate")
public class DailyCalculation extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String bal = request.getParameter("amount");
		String per = request.getParameter("Percent");
		HttpSession session = request.getSession();

		if (!bal.isEmpty() && !per.isEmpty()) {

			double balance = Double.parseDouble(bal);
			int percent = Integer.parseInt(per);

			double oneday = new LoginModel().dailyCalculator(balance, percent);

			if (oneday < 0) {
				session.setAttribute("message", "Insufficient Balance\n");
				session.setAttribute("oneday", null);
			} else {
				if (oneday > 500) {
					session.setAttribute("message", "You can save more if you want\n");
				} else {
					session.setAttribute("message", "Good to go\n");
				}
				session.setAttribute("oneday", "For one day you can spend up to : " + oneday + " Rs");
			}
		} else {
			session.setAttribute("message", "Invalid Input ");
		}
		response.sendRedirect("DailyCalculator.jsp");
	}
}
