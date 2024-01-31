<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<a href="chat?command=logout" name = "logout">Выход</a>
    <h1>User List</h1>
    <c:forEach var="user" items="${allUsers}">
        <c:out value ="Username: ${user.name}, Ban: ${user.banned} Type:${user.userType}"/>
        </br>
            <div>
                <form method="POST" action="chat?command=ban">
                <input type="hidden" name="userLogin" value="${user.login}">
                    <c:if test="${!user.banned}">
                        <button type="submit">BAN</button>
                    </c:if>
                    <c:if test="${user.banned}">
                         <button type="submit">UNBAN</button>
                    </c:if>
                 </form>
              </div>

    </c:forEach>



</body>
</html>