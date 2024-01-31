package org.example.listener;

import org.example.data.User;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

import static org.example.data.DataBase.getUserMap;


public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {

        HashMap<String,User> userMap = getUserMap();
        String userLog = (String) event.getSession().getAttribute("loginInput");
        User sessionUser = (User) userMap.get(userLog);

        if (sessionUser != null) {
            sessionUser.setOnline(false);
            System.out.println("Были очищены данные сессии для клиента - " + sessionUser.getName());
        }
    }
}
