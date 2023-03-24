package validations;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginprocess.LoginModel;

@WebServlet("/history")
public class History extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String name = (String) request.getAttribute("history");

		String history = request.getParameter("history");
		boolean today = "today".equals(history);

		boolean custom = "custom".equals(history);

		boolean complete = "complete".equals(history);

		String date = request.getParameter("date");

		HttpSession session = request.getSession();

		if(!today && !custom && !complete) {
			session.setAttribute("note", "Failed");
			response.sendRedirect("welcome.jsp");
			return;
		}
		if (custom && (date == null || date.isEmpty())) {
			session.setAttribute("note", "Failed");
			response.sendRedirect("welcome.jsp");
			return;
		} else {

			if (today) {
				date = LocalDate.now() + "";
			}
			if (complete) {
				date = null;
			}
			session.setAttribute("date", date);

			response.sendRedirect("history.jsp");
		}
	}
}