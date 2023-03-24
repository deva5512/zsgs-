<%@page import="loginprocess.LoginModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Daily Calculator</title>
<link rel="stylesheet" href="style.css">
</head>
<body id = "body">


    <div id = "inner">
        <h3 style="text-align: center;">Used to find how much spending will make your saving constant</h3>
        <div id = "calculateform">
        	<form method="post" action ="calculate">
            <table cellpadding= 10>
                <tr>
                    <td>Enter the amount </td>
                    <td><input type="number" name="amount" id = "amount"></td>
                </tr>

                <tr>
                    <td>Enter the Percent </td>
                    <td><input type="number" name="Percent" id = "Percent"></td>
                </tr>
                
                 <tr>
                    <td colspan = "2"><center><button type = "submit">Calculate</button></center></td>
                 </tr>
            </table>
            </form>
        </div>
    	<div id = "messageBlock">
            <%
	    	try{
	    		String message = (String)request.getSession().getAttribute("message");
	    		if(message != null)
	    			out.println(message);
	    		message = (String)request.getSession().getAttribute("oneday");
	    		if(message != null)
	    			out.println(message);
	    		
				session.removeAttribute("message");
				session.removeAttribute("oneday");
	    	}catch(Exception e){
	    		
	    	}
    	%>
        </div>
    </div>
   
    <script src="expence.js"></script>
</body>
</html>