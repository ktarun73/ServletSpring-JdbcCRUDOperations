<%--
  Created by IntelliJ IDEA.
  User: ktaru
  Date: 29-06-2023
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
        <%
            request.getRequestDispatcher("ShowData").include(request,response);
        %>
        <h3>Are you sure you want to delete th data for id <%= request.getParameter("id")%></h3>
        <a href="index.jsp">No.. go to index page</a><br>
        <a href="DeleteData?id=<%= request.getParameter("id") %>">Yes</a><br>
</body>
</html>
