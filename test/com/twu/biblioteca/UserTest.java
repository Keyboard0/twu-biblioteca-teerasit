package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class UserTest {

    @Test // 2.3 view checked out book
    public void shouldReturnListOfCheckedOutBook(){
        User testUser = new User("111-1234", "password111", "User1", "user1@gmail.com", "0912345678");
        String bookToCheckOut = "Title1";
        testUser.addBook(bookToCheckOut);
        assertThat(testUser.getCheckedoutBook(), is(containsString(bookToCheckOut)));
    }
    @Test // 2.3 view user information
    public void shouldReturnValidUserInformation() {
        User user1 = new User("111-1234", "password111", "User1", "user1@gmail.com", "0912345678");
        User user2 = new User("222-5678", "password222", "User2", "user2@gmail.com", "0900000000");
        User user3 = new User("333-1277", "password333", "User3", "user3@gmail.com", "0987654321");
        ArrayList<User> expected = new ArrayList<>(Arrays.asList(user1, user2, user3));
        Users testUserList = new Users();
        assertThat(testUserList.getUserList().size(), is(expected.size()));
        for (int i = 0; i < expected.size(); i++) {
            assertThat(testUserList.getUserList().get(i).getInformation(), is(expected.get(i).getInformation()));
        }
    }
}
