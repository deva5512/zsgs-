<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Details</title>
<link rel="stylesheet" href="style.css">
</head>
<body id = "body">

    <div id = "inner">
        <h3 style="text-align: center;">Modify Details</h3>
        <form action="modify" id = "modificationform">
            <table cellpadding = 5>

                <tr>
                    <td><label for="name">Name</label></td>
                    <td><input type="text" name="name" id="name" autocomplete="off"></td>
                </tr>

                <tr>
                    <td><label for="pass">Password</label></td>
                    <td><input type="text" name="pass" id="pass" autocomplete="off"></td>
                </tr>

                <tr>
                    <td><label for="balance">Balance</label></td>
                    <td><input type="number" name="balance" id="balance" autocomplete="off"></td>
                </tr>

                <tr>
                    <td><label for="percent">Percent</label></td>
                    <td><input type="number" name="percent" id="percent" autocomplete="off"></td>
                </tr>

                <tr>
                    <td><label for="fixed">Fixed Expece</label></td>
                    <td><input type="number" name="fixed" id="fixed" autocomplete="off"></td>
                </tr>

                <tr>
                    <td colspan="2"><center><button type="submit">Submit</button></center></td>
                </tr>

            </table>
        </form>
        <div id = "loginError">
            <%
	    	try{
	    		String message = (String)request.getSession().getAttribute("note");
	    		if(message != null)
	    			out.println(message);
	    		
	    		session.removeAttribute("note");
	    	}catch(Exception e){
	    		
	    	}
    	%>
        </div>
    </div>
    
</body>
</html>