package org.example.command.action;

import org.example.command.Command;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import static org.example.Resources.COMMAND_SHOW_BAN_PAGE;
import static org.example.data.DataBase.getUserMap;

public class BanCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String userLogin = request.getParameter("userLogin");
        HashMap<String, User> userMap = getUserMap();

        if (userMap.containsKey(userLogin)) {
            User bannedUser = userMap.get(userLogin);
            if (!bannedUser.isBanned()) {
                bannedUser.setBanned(true);
            } else {
                bannedUser.setBanned(false);
            }
        }
        return new RedirectResult(COMMAND_SHOW_BAN_PAGE);
    }
}
