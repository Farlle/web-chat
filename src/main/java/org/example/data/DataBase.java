package org.example.data;

import java.util.HashMap;

public final class DataBase {
    private static HashMap<String, User> userMap = new HashMap<>();

    public DataBase() {
    }

    public static void init() {

        User user1 = new User("sashok", "123", "Sashok", UserType.ADMIN);
        User user2 = new User("oleg", "123", "Oleg", UserType.CLIENT);
        User user3 = new User("dima", "123", "Dima", UserType.CLIENT);

        userMap.put(user1.getLogin(), user1);
        userMap.put(user2.getLogin(), user2);
        userMap.put(user3.getLogin(), user3);
        System.out.println("Установка соединения с Базой Данных");
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }

    public static HashMap<String, User> getUserMap() {
        return userMap;
    }
}
