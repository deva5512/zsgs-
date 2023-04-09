package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginModel;

@WebServlet("/addDeliveryDetails")
public class AddDeliveryDetails extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String address = request.getParameter("address");
		String number = request.getParameter("number");
		String pincode = request.getParameter("pincode");

		PrintWriter out = response.getWriter();

		try {
			long mobile = Long.parseLong(number);
			int pin = Integer.parseInt(pincode);

			HttpSession session = request.getSession();

			String mail = (String) session.getAttribute("mail");

			LoginModel model = new LoginModel();

			model.updateDeliveryAddress(mail, address, mobile, pin);
			
			out.print(true);

		} catch (Exception e) {
			out.print(false);
		}
	}

}
