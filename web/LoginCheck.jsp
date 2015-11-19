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
            String Registration = request.getParameter("Resgistration");
            String password = request.getParameter("password");
            String userType = request.getParameter("usertype");
            //need database info in here
            Connection con;
            ResultSet rs;
            Connection theConnection = null;
            PreparedStatement theStatement = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ESDpractical", "root", "");
                theStatement = theConnection.prepareStatement("select * from Drivers where Registration=? and password=?");
                theStatement.setString(1, request.getParameter("Registration"));
                theStatement.setString(2, request.getParameter("password"));
                rs = theStatement.executeQuery();

                if (rs.next()) {
                    if (Registration.equals("Admin")) {
                        
                        session.setAttribute("Registration", Registration);
                        response.sendRedirect("adminpage");
                    } else {
                        out.print("Driver stuff");
                        session.setAttribute("Registration", Registration);
                        response.sendRedirect("driver page");
                    }
                    System.out.println("Success");

                } else {
                    System.out.println("Failed");
                }
                rs.close();
                theStatement.close();
                con.close();
                //add if statement so if admin then go to admin page if driver go to driver page
            } catch (Exception e) {
                System.out.println("Exception occured! " + e.getMessage() + " " + e.getStackTrace());
            }
        %>
    </body>
</html>