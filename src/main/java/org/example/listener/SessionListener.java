package org.example.listener;

import org.example.data.User;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static org.example.data.DataBase.userMap;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        String userLog = (String) event.getSession().getAttribute("loginInput");
        User sessionUser = (User) userMap.get(userLog);

        if (sessionUser != null) {
            sessionUser.setOnline(false);
            System.out.println("Были очищены данные сессии для клиента - " + sessionUser.getName());
        }
    }
}
