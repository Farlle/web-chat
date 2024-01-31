package org.example.command;

import org.example.command.action.BanCommand;
import org.example.command.action.LoginCommand;
import org.example.command.action.LogoutCommand;
import org.example.command.show.ShowBanPageCommand;
import org.example.command.show.ShowChatPageCommand;
import org.example.command.show.ShowLoginPageCommand;

public enum CommandType {
    EMPTY(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    BAN(new BanCommand()),

    SHOW_CHAT_PAGE(new ShowChatPageCommand()),
    SHOW_LOGIN_PAGE(new ShowLoginPageCommand()),
    SHOW_BAN_PAGE(new ShowBanPageCommand()),

    ;

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
