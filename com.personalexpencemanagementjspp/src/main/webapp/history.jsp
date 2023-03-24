<%@page import="java.util.Iterator"%>
<%@page import="dto.Expence"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.Map"%>
<%@page import="loginprocess.LoginModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>
<link rel="stylesheet" href="style.css">
</head>
<body id="body">
	<table id="historytable" cellpadding=10 border="10">

		<%
		String date = (String) request.getSession().getAttribute("date");

		if (date == null || date.isEmpty()) {
			Map<String, LinkedList<Expence>> map = new LoginModel().getCompletehistory();

			if (map.isEmpty()) {
				request.getSession().setAttribute("note", "Empty");
				response.sendRedirect("welcome.jsp");
				return;
			}
			for (Map.Entry<String, LinkedList<Expence>> entry : map.entrySet()) {
				double total = 0;

				out.print("<tr> <td colspan=\"2\" >Date : " + entry.getKey() + "</td> </tr>");

				Iterator<Expence> it = entry.getValue().iterator();

				while (it.hasNext()) {
					Expence expence = it.next();

					out.print("<tr> <td>" + expence.getReason() + "</td> <td>" + expence.getAmount() + " Rs</td> </tr>");

					total += expence.getAmount();

				}
				out.print("<tr> <td>Total</td> <td>" + total + " Rs</td> </tr>");
			}

		} else {

			Map<String, LinkedList<Expence>> map = new LoginModel().getCustomhistory(date);

			if (map.isEmpty()) {
				request.getSession().setAttribute("note", "Failed");
				response.sendRedirect("welcome.jsp");
				return;
			}
			for (Map.Entry<String, LinkedList<Expence>> entry : map.entrySet()) {
				double total = 0;

				out.print("<tr> <td colspan=\"2\" >Date : " + entry.getKey() + "</td> </tr>");

				Iterator<Expence> it = entry.getValue().iterator();

				while (it.hasNext()) {
					Expence expence = it.next();

					out.print("<tr> <td>" + expence.getReason() + "</td> <td>" + expence.getAmount() + " Rs</td> </tr>");  

					total += expence.getAmount();

				}
				out.print("<tr> <td>Total</td> <td>" + total + " Rs</td> </tr>");
			}

		}
		%>
	</table>

</body>
</html>