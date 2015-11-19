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
            try {
                String Name = request.getParameter("Name");
                String password = request.getParameter("password");
                Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Alpha", "root", "");
                PreparedStatement pst = conn.prepareStatement("Select Name,password from Drivers where Name=? and password=?");
                pst.setString(1, Name);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                out.println("Registration is " + Name);
                out.println("pass" + password);
                if (rs.next()) {
                    out.println("Valid login credentials");
                } else {
                    out.println("Invalid login credentials");
                }
            } catch (Exception e) {
                out.println("Something went wrong !! Please try again");
            }


        %>
    </body>
</html>