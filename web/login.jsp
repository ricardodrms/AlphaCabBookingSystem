    <%@page contentType="text/html" pageEncoding="UTF-8"%> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Login Form</title> 
    </head> 
    <body bgcolor="#80CBC4"> 
        <h1>Login Page</h1> 
        <fieldset>
           <center>
      <legend><h2>Sign in Details</h2> </legend>
        <form action="LoginCheck.jsp" method="post"> 

            <br/>Registration:<input type="text" name="Registration"/> 
            <br/>Password:<input type="password" name="password"/> 
            <br/>
            <tr>
            <td>usertype</td>
            <td>
                <select name="usertype">
                    <option value="Admin">Admin</option>
                    <option value="Driver">Driver</option>
                </select>
            </td>
            </tr>
            <tr>
                <td>
            <br/><input type="submit" value="Submit" name="bt"/> 
            <input type="reset" value="Reset">
                </td>
            </tr>
            <!--if statement for checking if-->
        </form> 
    </center> 
                </fieldset>
        </body> 
        </html>
