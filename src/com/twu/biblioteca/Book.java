package com.twu.biblioteca;

public class Book extends Item{
    private String author;
    private int year;

    public Book(String title, String author, int year, boolean checkedOut) {
        super(title);
        this.author = author;
        this.year = year;
        this.setCheckout(checkedOut);
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getBookInfo() {
        if (this.isCheckout()) {
            return "";
        } else {
            return String.format("%-10s | %-10s | %d", this.getTitle(), this.getAuthor(), this.getYear());
        }
    }
}
