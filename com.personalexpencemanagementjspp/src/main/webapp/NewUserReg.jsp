<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Registration</title>
<link rel="stylesheet" href="style.css">
</head>
<body id = "body">

    <div id = "inner">
        <h3 style="text-align: center;">New User Registration</h3>
        <form action="checkprevious" id = "loginForm" method = "post">
            <table cellspacing = 13>
                <tr>
                    <td>Name </td>
                    <td><input type="text" name="name" autocomplete="off"></td>
                </tr>

                <tr>
                    <td>Password </td>
                    <td><input type="password" name="pass"></td>
                </tr>

                <tr>
                    <td>Re enter </td>
                    <td><input type="password" name="reenter"></td>
                </tr>

                <tr>
                    <td colspan = "2"><center><button type="submit" id = "login">Sign UP</button></center></td>
                </tr>
            </table>
        </form>
        
        <div id = newUserError>
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