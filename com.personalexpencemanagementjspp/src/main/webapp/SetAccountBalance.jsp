<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Account Balance</title>
<link rel="stylesheet" href="style.css">
</head>
<body id = "body">

    <div id = "inner">
        <h3 style="text-align: center;">Before starting You need to Submit Certain information</h3>
        <form action="setBalance" method = "post" id = "required">
            <table cellpadding= 10>
                <tr>
                    <td>Enter you Balance</td>
                    <td><input type="number" name="balance" autocomplete="off"></td>
                </tr>

                <tr>
                    <td>Enter the percent wish to save</td>
                    <td><input type="number" name="percent" autocomplete="off"></td>
                </tr>

                <tr>
                    <td>Enter your fixed expence</td>
                    <td><input type="number" name="fixed" autocomplete="off"></td>
                </tr>

                <tr>
                    <td colspan="2"><center><input type="submit"></center></td>
                </tr>
            </table>
        </form>
        <div id = "setbalance">
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