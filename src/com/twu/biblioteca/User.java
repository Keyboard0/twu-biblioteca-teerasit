package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String libraryNumber;
    private String password;
    private ArrayList<String> checkedoutBook;
    private ArrayList<String> checkedoutMovie;
    private String email;
    private String phoneNumber;
    private String name;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber){
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

    public String getCheckedoutBook() {
        String returnString = "";
        for(String bookTitle: checkedoutBook){
            returnString += bookTitle + "\n";
        }
        return returnString;
    }

    public String getCheckedoutMovie() {
        String returnString = "";
        for(String mobieTitle: checkedoutMovie){
            returnString += mobieTitle + "\n";
        }
        return returnString;
    }

    public String getInformation(){
        return String.format("%-10s | %-20s | %-10s", this.name, this.email, this.phoneNumber);
    }

    public void addBook(String bookTitle){
        this.checkedoutBook.add(bookTitle);
    }
    public void removeBook(String bookTitle){
        this.checkedoutBook.remove(bookTitle);
    }
    public void addMovie(String movieTitle){
        this.checkedoutMovie.add(movieTitle);
    }
    public void removeMovie(String movieTitle){
        this.checkedoutMovie.remove(movieTitle);
    }
}
