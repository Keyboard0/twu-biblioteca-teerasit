package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Books {
    private ArrayList<Book> bookShelf;

    public Books() {
        setup();
    }

    private void setup() {
        Book book1 = new Book("Title1", "Arthor1", 1991, false);
        Book book2 = new Book("Title2", "Arthor2", 1992, false);
        Book book3 = new Book("Title3", "Arthor3", 1993, false);
        bookShelf = new ArrayList<>(Arrays.asList(book1, book2, book3));
    }

    public ArrayList<Book> getListBook() {
        return bookShelf;
    }

    public boolean checkoutTheBook(String bookToCheckout) {
        for (Book book : bookShelf) {
            if (bookToCheckout.equals(book.getTitle()) && !(book.isCheckedOut())) {
                book.setCheckedOut(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnTheBook(String bookToReturn) {
        for (Book book : bookShelf) {
            if (bookToReturn.equals(book.getTitle()) && (book.isCheckedOut())) {
                book.setCheckedOut(false);
                return true;
            }
        }
        return false;
    }
}
