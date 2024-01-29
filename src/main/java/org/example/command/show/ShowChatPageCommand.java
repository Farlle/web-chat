package org.example.command.show;

import org.example.command.Command;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import static org.example.Resources.PAGE_CHAT;

public class ShowChatPageCommand implements Command {
    List<Message> messages;

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String text = request.getParameter("message1");
        String user = request.getParameter("sender");
        Message message = new Message(user, text);

        System.out.println(text + "\n" + user);
        // Ваша реализация наполнения данными главной страницы чата

        List<Message> messages = (List<Message>) request.getServletContext().getAttribute("messages");
        if (messages == null) {
            messages = new ArrayList<>();
            request.getServletContext().setAttribute("messages", messages);
        }

        // Добавляем новое сообщение в список
        messages.add(message);

        return new ForwardResult(PAGE_CHAT);
    }
}
