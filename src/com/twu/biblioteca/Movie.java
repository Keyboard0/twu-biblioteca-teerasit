package com.twu.biblioteca;

public class Movie extends Item{
    private final int year;
    private final String director;
    private final String rating;

    public Movie(String title, int year, String director, String rating, boolean checkedOut) {
        super(title);
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.setCheckout(checkedOut);
    }
    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

    public String getMovieInfo() {
        if (this.isCheckout()) {
            return "";
        } else {
            return String.format("%-20s | %d | %-15s | %-10s", this.getTitle(), this.getYear(), this.getDirector(), this.getRating());
        }
    }
}