package com.twu.biblioteca;

public class Movie extends Item{
    //Movies have a name, year, director and movie rating (from 1-10 or unrated).
//    private final String title;
    private final int year;
    private final String director;
    private final String rating;
//    private boolean checkedOut;

    public Movie(String title, int year, String director, String rating, boolean checkedOut) {
        super(title);
//        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
//        this.checkedOut = checkedOut;
        this.setCheckout(checkedOut);
    }

//    public String getTitle() {
//        return title;
//    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

//    public boolean isCheckedOut() {
//        return checkedOut;
//    }

    public String getMovieInfo() {
        if (this.isCheckout()) {
            return "";
        } else {
            return String.format("%-20s | %d | %-15s | %-10s", this.getTitle(), this.getYear(), this.getDirector(), this.getRating());
        }
    }

//    public void setCheckedOut(boolean checkedOut) {
//        this.checkedOut = checkedOut;
//    }
}