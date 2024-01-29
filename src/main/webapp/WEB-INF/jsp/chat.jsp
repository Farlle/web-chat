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
        <div align="center">
            <a href="chat?command=logout">Выход</a>
            <p>Вы вошли как: <c:out value="${loginInput}" /></p>

            <!-- Главная страница Чата -->
            <div id="chat-window">
                <!-- Сообщения будут добавляться здесь -->
               <div id="chat-window">
                               <c:forEach var="message" items="${applicationScope.messages}">
                                   <div><c:out value="${message.sender}: ${message.text}" /></div>
                               </c:forEach>
                           </div>
            <form id="chat-form" action="chat?command=show_chat_page" method="POST">
                <input type="hidden" name="command" value="send">
                <input type="hidden" name="sender" value="${loginInput}">
                <input type="text" id="message-input" name="message1" placeholder="Type a message..." autocomplete="off">
                <button type="submit">Send</button>
            </form>
        </div>
    </body>
</html>