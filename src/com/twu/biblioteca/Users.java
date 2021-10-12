package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Users {
    private ArrayList<User> userList;

    public Users() {
        setup();
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setup() {
        User user1 = new User("111-1234", "password111", "User1", "user1@gmail.com", "0912345678");
        User user2 = new User("222-5678", "password222", "User2", "user2@gmail.com", "0900000000");
        User user3 = new User("333-1277", "password333", "User3", "user3@gmail.com", "0987654321");
        userList = new ArrayList<>(Arrays.asList(user1, user2, user3));
    }

    public User login(User userToVerify) {
        for (User user : userList) {
            if (user.getLibraryNumber().equals(userToVerify.getLibraryNumber()) && user.getPassword().equals(userToVerify.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
