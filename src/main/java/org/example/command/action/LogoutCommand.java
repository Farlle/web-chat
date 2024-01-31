package org.example.command.action;

import org.example.command.Command;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.PAGE_LOGIN;
import static org.example.data.DataBase.userMap;

public class LogoutCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String userLog = (String) request.getSession().getAttribute("loginInput");
        User user = (User) userMap.get(userLog);

        if (user != null) {
            request.getSession().invalidate();
        }
        return new ForwardResult(PAGE_LOGIN);
    }
}
