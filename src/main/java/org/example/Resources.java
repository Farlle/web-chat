package org.example;

public final class Resources {

    public static final String PAGE_LOGIN = "/WEB-INF/jsp/login.jsp";
    public static final String PAGE_CHAT = "/WEB-INF/jsp/chat.jsp";
    public static final String PAGE_BAN = "/WEB-INF/jsp/admin.jsp";

    public static final String COMMAND_SHOW_LOGIN_PAGE = "chat?command=show_login_page";
    public static final String COMMAND_SHOW_CHAT_PAGE = "chat?command=show_chat_page";

    public static final String COMMAND_SHOW_BAN_PAGE = "chat?command=show_ban_page";

    private Resources() {
    }
}
