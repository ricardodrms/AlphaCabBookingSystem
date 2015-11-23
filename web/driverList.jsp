<%-- 
    Document   : driverList.jsp
    Created on : 23-Nov-2015, 20:34:20
    Author     : Kyran
--%>

<%@page import="models.DriverDB"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="models.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alphacab</title>
    </head>
    <body>
        <h1>All Alphacab drivers</h1>
        <br><br>
        <table  border="1" style="width:50%">
            <tr>
                <th>Registration</th>
                <th>Name</th> 
                <th>Action</th>
            </tr>
            <%
                DriverDB driverDB = new DriverDB((Connection) request.getServletContext().getAttribute("connection"));
                List<Driver> drivers = driverDB.getAllDrivers();
                Driver c;
                for (int i = 0; i < drivers.size(); i++) {
                    c = drivers.get(i);
                    out.println("<tr>");
                    out.println("<td>" + c.getReg() + "</td>");
                    out.println("<td>" + c.getName() + "</td>");
                    out.println("<td><button class=\"deletebtn\">delete</button></td>");
                    out.println("</tr>");
                }

            %>
        </table>
    </body>
</html>
