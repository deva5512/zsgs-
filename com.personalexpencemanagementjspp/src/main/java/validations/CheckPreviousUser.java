package validations;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginprocess.LoginModel;

@WebServlet("/checkprevious")
public class CheckPreviousUser extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String pass = request.getParameter("pass");
		String pass1 = request.getParameter("reenter");
		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();

		if (name.isEmpty() ||pass.isEmpty() || pass1.isEmpty() ||!pass.equals(pass1)) {
			response.sendRedirect("NewUserReg.jsp");
			session.setAttribute("fail", "Invalid input");
			return;
		}

		LoginModel model = new LoginModel();
		boolean res = model.checkExistingUser(name, pass);

		if (res) {
			response.sendRedirect("SetAccountBalance.jsp");
		}else {
			response.sendRedirect("NewUserReg.jsp");
			session.setAttribute("fail", "User name alredy Exist");
		}
	}
}
