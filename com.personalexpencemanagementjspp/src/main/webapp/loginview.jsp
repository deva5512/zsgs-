<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="style.css">
</head>
<body id = "body">

    <div id = "inner">
        <form action="verifylogin" id = "loginForm" method = "post">
        
          <table cellspacing = 15>
                <tr>
                    <td><label for="name">User name </label></td>
                    <td><input type = "text" name = "name" autocomplete="off"></td>
                    </tr>
               <tr>
                    <td><label for="pass">Password </label></td>
                    <td><input type = "password" name = "pass"></td>
                </tr>
                <tr >
                    <td colspan = "2"><center><button type="submit" id = "login">Sign in</button></center></td>
                </tr>

                <a href="NewUserReg.jsp" id = "new" class = "buttons">New User</a>
                <a href="DailyCalculator.jsp" id = "daily" class = "buttons">Daily Calculator</a>
        
            </table>
        </form>
        <div id = "loginError">
            <%
	    	try{
	    		String message = (String)request.getSession().getAttribute("fail");
	    		if(message != null)
	    			out.println(message);
	    		
	    		session.removeAttribute("fail");
	    	}catch(Exception e){
	    		
	    	}
    	%>
        </div>
    </div>
  
</body>
</html>