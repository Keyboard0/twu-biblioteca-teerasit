package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean checkedOut;

    public Book(String title, String author, int year, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public int getYear() {
        return year;
    }

    public String getBookInfo() {
        if (this.checkedOut) {
            return "";
        } else {
            return String.format("%-10s | %-10s | %d", this.getTitle(), this.getAuthor(), this.getYear());
        }
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
