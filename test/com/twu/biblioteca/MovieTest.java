package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieTest {

    @Test /* test 1.3 view a list all books */
    public void shouldReturnPredefinedBooks(){
        Movie movie1 = new Movie("Black Widow", 2021, "Cate Shortland", "7", false);
        Movie movie2 = new Movie("Godzilla vs. Kong", 2021, "Adam Wingard", "6", false);
        Movie movie3 = new Movie("Oxygen", 2021, "Alexandre Aja", "7", false);
        Movie movie4 = new Movie("No Time to Die", 2021, "Cary Joji Fukunaga", "Unrated", false);
        ArrayList<Movie> expected = new ArrayList<>(Arrays.asList(movie1, movie2, movie3, movie4));
        Movies actual = new Movies();

        assertThat(actual.getMovieShelf().size(), is(expected.size()));
        for(int i=0; i<actual.getMovieShelf().size(); i++){
            assertThat(actual.getMovieShelf().get(i).getMovieInfo(), is(expected.get(i).getMovieInfo()));
        }


    }
}
