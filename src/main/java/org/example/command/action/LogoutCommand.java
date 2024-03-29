package org.example.command.action;

import org.example.command.Command;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;

import static org.example.Resources.PAGE_LOGIN;
import static org.example.data.DataBase.getUserMap;

public class LogoutCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, User> userMap = getUserMap();
        String userLog = (String) request.getSession().getAttribute("loginInput");
        User user = userMap.get(userLog);

        if (user != null) {
            request.getSession().invalidate();
        }
        return new ForwardResult(PAGE_LOGIN);
    }
}
