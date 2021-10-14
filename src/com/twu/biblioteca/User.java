package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private final String libraryNumber;
    private final String password;
    private final ArrayList<String> checkoutsBook;
    private final ArrayList<String> checkoutsMovie;
    private final String email;
    private final String phoneNumber;
    private final String name;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.checkoutsBook = new ArrayList<>();
        this.checkoutsMovie = new ArrayList<>();
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }



    public String getCheckoutsMovie() {
        StringBuilder returnString = new StringBuilder();
        for (String mobieTitle : checkoutsMovie) {
            returnString.append(mobieTitle).append("\n");
        }
        return returnString.toString();
    }

    public String getInformation() {
        return String.format("%-10s | %-20s | %-10s", this.name, this.email, this.phoneNumber);
    }

    public void addBook(String bookTitle) {
        this.checkoutsBook.add(bookTitle);
    }

    public void removeBook(String bookTitle) {
        this.checkoutsBook.remove(bookTitle);
    }

    public void addMovie(String movieTitle) {
        this.checkoutsMovie.add(movieTitle);
    }

    public void removeMovie(String movieTitle) {
        this.checkoutsMovie.remove(movieTitle);
    }

    public String getCheckoutsBook() {
        StringBuilder returnString = new StringBuilder();
        for (String bookTitle : checkoutsBook) {
            returnString.append(bookTitle).append("\n");
        }
        return returnString.toString();
    }
}
