package org.example.command.action;

import org.example.command.Command;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;
import static org.example.data.DataBase.getUserMap;

public class LoginCommand implements Command {


    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");

        HashMap<String, User> userMap = getUserMap();

        if (userMap.containsKey(username)) {
            User user = userMap.get(username);
            if (password.equals(user.getPassword())) {
                user.setOnline(true);
                request.getSession().setAttribute("loginInput", username);
                request.getSession().setAttribute("user", user);
                return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
            }
        }
        // Ваша реализация выполнения входа в Чат
        return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
    }
}
