<%@page import ="java.sql.*" %>
<%@page import ="java.io.IOException" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.io.*"%>
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Check</title> 
    </head> 
    <body> 
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String userType = request.getParameter("usertype");
            //need database info in here
            String driver = "oracle.jdbc.driver.OracleDriver";
            String dbURL = "jdbc:oracle:thin:@10.113.130.22:1521:ORCL";
            String dbuser = "user";
            String dbpassword = "password";
            Connection theConnection = null;
            PreparedStatement theStatement = null;

            try {
                Class.forName(driver);
                theConnection = DriverManager.getConnection(dbURL, dbuser, dbpassword);
                theStatement = theConnection.prepareStatement("select * from USERNAME where username=? and password=?");
                theStatement.setString(1, request.getParameter("username"));
                theStatement.setString(2, request.getParameter("password"));
                ResultSet theResult = theStatement.executeQuery();

                if (theResult.next()) {
                    System.out.println("Success");
                } else {
                    System.out.println("Failed");
                }
                
                //add if statement so if admin then go to admin page if driver go to driver page
                

            } catch (Exception e) {
                System.out.println("Exception occured! " + e.getMessage() + " " + e.getStackTrace());
            }
        %>
    </body>
</html>