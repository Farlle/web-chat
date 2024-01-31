package org.example.command.show;

import org.example.command.Command;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static org.example.Resources.PAGE_BAN;
import static org.example.data.DataBase.getUserMap;

public class ShowBanPageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, User> userMap = getUserMap();

        Collection<User> allUsers = userMap.values();
        request.setAttribute("allUsers", allUsers);
        return new ForwardResult(PAGE_BAN);
    }
}
