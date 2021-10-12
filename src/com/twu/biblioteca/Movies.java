package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Movies {
    private ArrayList<Movie> movieShelf;
    public Movies(){
        setup();
    }
    public void setup(){
        Movie movie1 = new Movie("Black Widow", 2021, "Cate Shortland", "7", false);
        Movie movie2 = new Movie("Godzilla vs. Kong", 2021, "Adam Wingard", "6", false);
        Movie movie3 = new Movie("Oxygen", 2021, "Alexandre Aja", "7", false);
        Movie movie4 = new Movie("No Time to Die", 2021, "Cary Joji Fukunaga", "Unrated", false);
        movieShelf = new ArrayList<>(Arrays.asList(movie1, movie2, movie3, movie4));
    }

    public ArrayList<Movie> getMovieShelf() {
        return movieShelf;
    }

    public boolean checkoutMovie(String movieToCheckout) {
        for (Movie movie : movieShelf) {
            if (movieToCheckout == movie.getTitle() && !(movie.isCheckedOut())) {
                movie.setCheckedOut(true);
                return true;
            }
        }
        return false;
    }
}
