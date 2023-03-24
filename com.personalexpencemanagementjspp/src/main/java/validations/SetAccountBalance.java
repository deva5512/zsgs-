package validations;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginprocess.LoginModel;

@WebServlet("/setBalance")
public class SetAccountBalance extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String bal = request.getParameter("balance");
		String per = request.getParameter("percent");
		String fix = request.getParameter("fixed");

		HttpSession session = request.getSession();

		if (bal.isEmpty() || per.isEmpty() || fix.isEmpty() || per.contains(".")) {
			response.sendRedirect("SetAccountBalance.jsp");
			session.setAttribute("fail", "Invalid input ");
			return;
		}
		
		LoginModel model = new LoginModel();
		double balance = Double.parseDouble(bal);
		int percent = Integer.parseInt(per);
		double fixed = Double.parseDouble(fix);
		
		if(balance < 10000 && percent > 10) {
			response.sendRedirect("SetAccountBalance.jsp");
			session.setAttribute("fail", "Invalid input ");
			return;
		}

		boolean res = model.checkPosible(balance, fixed, percent);

		if (res) {
			model.setAccountBalance(balance, fixed, percent);
			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("SetAccountBalance.jsp");
			session.setAttribute("fail", "Insufficient balance ");
		}
	}
}
