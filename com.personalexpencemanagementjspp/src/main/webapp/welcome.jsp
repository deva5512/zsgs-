<%@page import="loginprocess.LoginModel"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
<link rel="stylesheet" href="style.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet"
	href="https://unpkg.com/sweetalert/dist/sweetalert.css">
</head>
<body id="body">

	<input type="text" id="status"
		value="<%=request.getSession().getAttribute("status")%>">

	<input type="text" id="note"
		value="<%=request.getSession().getAttribute("note")%>">

	<table cellpadding=10 id="details">
		<tr>
			<th colspan="3"><u>Date : <%
			String date = LocalDate.now() + "";
			out.print(date);
			%></u></th>
		</tr>

		<tr>
			<td>User Name</td>
			<td>
				<%
				String name = LoginModel.user.getName();
				String pass = LoginModel.user.getPin();
				double balance = LoginModel.user.getBalance();
				int percent = LoginModel.user.getPercent();
				double fixed = LoginModel.user.getFixedExpence();
				double today = LoginModel.user.getTodayspending();
				double oneday = LoginModel.user.getAllowedonedayamount();
				out.print(name);
				%>
			</td>
		</tr>

		<tr>
			<td>Pin</td>
			<td>
				<%
				out.print(pass);
				%>
			</td>
		</tr>

		<tr>
			<td>Balance</td>
			<td>
				<%
				out.print(balance);
				%>
			</td>
		</tr>

		<tr>
			<td>Saving Percent</td>
			<td>
				<%
				out.print(percent);
				%> %
			</td>
		</tr>

		<tr>
			<td>Fixed Expence</td>
			<td>
				<%
				out.print(fixed);
				%>
			</td>
		</tr>

		<tr>
			<td>Day Limit</td>
			<td colspan="2">
				<%
				out.print(oneday);
				%>
			</td>
		</tr>

		<tr>
			<td>Today Spending</td>
			<td colspan="2">
				<%
				out.print(today);
				%>
			</td>
		</tr>

	</table>

	<div id="features">
		<center>
			<a href="modifyDetails.jsp" id="modify" class="buttons">Modify
				Details</a>
		</center>
		<form method="post" action="addExpence">
			<table cellpadding=5 id="enterExpence">
				<tr>
					<th colspan="2">
						<center>
							<u>Enter Expence</u>
						</center>
					</th>
				</tr>
				<tr>
					<th><label for="amount">Amount </label></th>
					<td><input type="number" name="amount" autocomplete="false"></td>
				</tr>
				<tr>
					<th><label for="reason">Reason </label></th>
					<td><textarea name="reason" id="reason" cols="30" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><center>
							<button type="submit">Add Expence</button>
						</center></td>
				</tr>
			</table>
		</form>

		<div id="historyBlock">
			<br>
			<form method="post" action="history">
				<center>
					<label for="history"><u>History</u></label>
				</center>
				<br> <input type="radio" name="history" id="history"
					value="today"> Today <br> <input type="radio"
					name="history" id="history" value="custom"> Custom Date <input
					type="date" name="date"> <br> <input type="radio"
					name="history" id="history" value="complete"> Complete<br>
				<br>
				<button type="submit">Get History</button>
			</form>

		</div>
	</div>

	<script type="text/javascript">
		var status = String(document.getElementById("status").value);

		if (status == "success") {
			swal("Success!", "Expence Added Successfully", "success");
		} else if (status == "failed") {
			swal("Oops!", "Crossing your balance limit", "error");
		} else if (status == "warning") {
			swal("Warning!", "Daily Limit Reached", "success");
		} else if (status == "empty") {
			swal("Oops!", "Invalid Amount", "error");
		}
	<%request.getSession().removeAttribute("status");%>
		
	</script>

	<script type="text/javascript">
		var note = String(document.getElementById("note").value);
		if (note == "Failed") {
			swal("Oops!", "Invalid Requst", "error");
		} else if (note == "Empty") {
			swal("Oops!", "No History Available", "error");
		}
	<%request.getSession().removeAttribute("note");%>
		
	</script>


</body>
</html>