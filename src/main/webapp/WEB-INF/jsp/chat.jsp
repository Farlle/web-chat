 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Чат</title>
        <style>
            #chat-window {
                height: 400px;
                overflow-y: auto;
                border: 1px solid #ccc;
                padding: 10px;
                margin-bottom: 10px;
            }
            #message-input {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>



    </div>
    <a href="chat?command=logout" name = "logout">Выход</a>
        <div align="center">
            <p>Вы вошли как: <c:out value="${loginInput}" /></p>

            <div id="chat-window">
                <c:forEach var="message" items="${messages}">
                       <c:if test="${not empty message.text}">
                           <div><c:out value="${message.sender}: ${message.text}" /></div>
                       </c:if>
                  </c:forEach>
                  </div>
            <form id="chat-form" action="chat?command=show_chat_page" method="POST">
                <input type="hidden" name="command" value="send">
                <input type="hidden" name="sender" value="${loginInput}">
                <input type="text" id="message-input" name="message" placeholder="Type a message..." autocomplete="off"
                value="<c:out value='${sessionScope.tmpMessage}'/>">

                <button type="submit" <c:if test="${user.banned}">disabled</c:if>>Send</button>
            </form>
             <c:if test="${user.userType == 'ADMIN'}">
                <a href="chat?command=show_ban_page">Ban Page</a>
             </c:if>
        </div>
    </body>
</html>