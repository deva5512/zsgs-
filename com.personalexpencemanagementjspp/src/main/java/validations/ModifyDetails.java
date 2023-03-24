package validations;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.InternalFrameUI;

import loginprocess.LoginModel;

@WebServlet("/modify")
public class ModifyDetails extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String bal = request.getParameter("balance");
		String per = request.getParameter("percent");
		String fix = request.getParameter("fixed");

		HttpSession session = request.getSession();

		if (name.isEmpty() && pass.isEmpty() && bal.isEmpty() && per.isEmpty() && fix.isEmpty()) {
			session.setAttribute("note", "Modify any one data to proceed modification");
			response.sendRedirect("modifyDetails.jsp");
			return;
		} else if (per.indexOf('.') != -1) {
			session.setAttribute("note", "Invalid modification Percent cant be in decimals");
			response.sendRedirect("modifyDetails.jsp");
			return;
		}
		LoginModel model = new LoginModel();
		if (!name.isEmpty()) {
			model.changeUserName(name);
		}
		if (!pass.isEmpty()) {
			model.changeUserPin(pass);
		}
		if (!bal.isEmpty()) {
			double balance = Double.parseDouble(bal);
			model.modifyBalance(balance);
		}
		if (!per.isEmpty()) {
			int percent = Integer.parseInt(per);
			model.modifyPercent(percent);
		}
		if (!fix.isEmpty()) {
			double fixed = Double.parseDouble(fix);
			model.modifyFixedExpence(fixed);
		}

		session.setAttribute("note", "Modified Successfully");
		response.sendRedirect("modifyDetails.jsp");
	}
}