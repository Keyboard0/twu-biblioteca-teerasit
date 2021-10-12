package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private final String libraryNumber;
    private final String password;
    private final ArrayList<String> checkedoutBook;
    private final ArrayList<String> checkedoutMovie;
    private final String email;
    private final String phoneNumber;
    private final String name;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.checkedoutBook = new ArrayList<>();
        this.checkedoutMovie = new ArrayList<>();
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getCheckoutsBook() {
        StringBuilder returnString = new StringBuilder();
        for (String bookTitle : checkedoutBook) {
            returnString.append(bookTitle).append("\n");
        }
        return returnString.toString();
    }

    public String getCheckedoutMovie() {
        StringBuilder returnString = new StringBuilder();
        for (String mobieTitle : checkedoutMovie) {
            returnString.append(mobieTitle).append("\n");
        }
        return returnString.toString();
    }

    public String getInformation() {
        return String.format("%-10s | %-20s | %-10s", this.name, this.email, this.phoneNumber);
    }

    public void addBook(String bookTitle) {
        this.checkedoutBook.add(bookTitle);
    }

    public void removeBook(String bookTitle) {
        this.checkedoutBook.remove(bookTitle);
    }

    public void addMovie(String movieTitle) {
        this.checkedoutMovie.add(movieTitle);
    }

    public void removeMovie(String movieTitle) {
        this.checkedoutMovie.remove(movieTitle);
    }
}
