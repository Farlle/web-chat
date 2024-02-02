package org.example.command.show;

import org.example.command.Command;
import org.example.data.Message;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.example.Resources.PAGE_CHAT;


public class ShowChatPageCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String text = request.getParameter("message");
        String user = request.getParameter("sender");

        Message message = new Message(user, text);
        List<Message> messages = (List<Message>) request.getServletContext().getAttribute("messages");
        synchronized (request.getServletContext()) {
            if (messages == null) {
                messages = new ArrayList<>();
                request.getServletContext().setAttribute("messages", messages);
            }
        }

        messages.add(message);
        response.setIntHeader("Refresh", 10);
        return new ForwardResult(PAGE_CHAT);
    }
}
