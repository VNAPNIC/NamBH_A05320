<%-- 
    Document   : Home
    Created on : Apr 15, 2015, 7:15:46 PM
    Author     : NamIT
--%>

<%@page import="entity.Libary"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <c:if test="${!empty sessionScope['login']}">
            <h1>Hello: ${sessionScope['login']}</h1>
        </c:if>
        <br />
        <h1>Book</h1>
        <br/>
        <form action="update" name="Select" method="post">
            <input type="hidden" name="name" value="${sessionScope['login']}">
            Sreach: &nbsp;<input type="text" name="sreach"> &nbsp;<input type="submit" value="Sreach">
        </form>
        <br />
        <table border="1">
            <th>Code</th>
            <th>Name</th>
            <th>Author</th>
            <th>BON</th>
            <th>Action</th>
                    <c:forEach var="emp" items="${requestScope.Book}">
                    <tr>
                        <td><c:out value="${emp.code}"></c:out></td>
                        <td><c:out value="${emp.name}"></c:out></td>
                        <td><c:out value="${emp.auther}"></c:out></td>
                        <td><c:out value="${emp.bon}"></c:out></td>
                            <td> 
                                <form action="StatusController" name="UpdateForm" method="post">
                                    <input type="submit" value="Update">
                                    <input type="hidden" name="name" value="${sessionScope['login']}">
                                    <input type="hidden" name="updateCode" value="${emp.code}">
                                    <input type="hidden" name="updateBON" value="${emp.bon}">
                                    <input type="hidden" name="action" value="UPDATE">
                                </form>
                        </td>
                    </tr>
                </c:forEach>
        </table>

        <br />
        <br />
        <br />
        <h1>Story</h1>
        <table border="1">
            <th>ID</th>
            <th>Date</th>
            <th>User</th>
            <th>Code book</th>
                <c:forEach var="emp1" items="${requestScope.Story}">
                <tr>
                    <td><c:out value="${emp1.id}"></c:out></td>
                    <td><c:out value="${emp1.date}"></c:out></td>
                    <td><c:out value="${emp1.user}"></c:out></td>
                    <td><c:out value="${emp1.code}"></c:out></td>
                    </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
