<%--
  Created by IntelliJ IDEA.
  User: ktaru
  Date: 29-06-2023
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
        <%
            request.getRequestDispatcher("ShowData").include(request,response);
        %>

        <br>
        <form action="UpdateData" method="post">
            <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
            <select name="update" id="update">
                <option value="name">Name</option>
                <option value="city">City</option>
            </select>
            <br/>
            <input type="text" name="updated_value" placeholder="Enter Updated Value">
            <br/>
            <button type="submit">proceed</button>
        </form>
</body>
</html>
