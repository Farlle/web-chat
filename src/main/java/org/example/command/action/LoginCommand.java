package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;
import static org.example.data.DataBase.userMap;

public class LoginCommand implements Command {


    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");

        if (userMap.containsKey(username)) {
            System.out.println("Успех!");
            request.getSession().setAttribute("loginInput", username);
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
        }

        // Ваша реализация выполнения входа в Чат
        System.out.println(username + "/n" + password + "asd");
        return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
    }
}
