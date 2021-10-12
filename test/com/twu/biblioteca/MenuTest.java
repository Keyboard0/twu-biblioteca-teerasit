package com.twu.biblioteca;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MenuTest {

    @Test //1.1
    public void shouldReturnWelcomeWhenOpenApp() {
        Menu mainMenu = new Menu();
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        assertThat(mainMenu.getWelcome(), is(expected));
    }

    @Test //1.3 View author and publication year on all books
    public void shouldReturnAllBookDetailWhenNeeded() {
        Menu mainMenu = new Menu();
        String book1 = "Title1";
        String book2 = "Title2";
        String book3 = "Title3";
        String arthor1 = "Arthor1";
        String arthor2 = "Arthor2";
        String arthor3 = "Arthor3";
        assertThat(mainMenu.getBooksInShelf(), is(allOf(
                containsString(book1),
                containsString(book2),
                containsString(book3),
                containsString(arthor1),
                containsString(arthor2),
                containsString(arthor3)
        )));
    }

    @Test //1.4 view a main menu of option
    public void shouldReturnMainMenuWhenAccessAppMenu() {
        Menu mainMenu = new Menu();
        String expected = "Main menu";
        assertThat(mainMenu.getMenuOption(), is(containsString(expected)));
    }

    @Test //1.5 get notified when I chose an invalid option
    public void shouldReturnInvalidMessageWhenInputInvalidOption() {
        Menu mainMenu = new Menu();
        String expected = "Please select a valid option!";
        assertThat(mainMenu.getInvalidMessage(), is(expected));
    }

    @Test //1.6 Quit the application
    public void shouldReturnExitMessageWhenUserWantToExitApp() {
        Menu mainMenu = new Menu();
        String expected = "Exiting";
        assertThat(mainMenu.getExitMessage(), is(containsString(expected)));
    }

    @Test //1.7 checkout a book
    public void shouldReturnTrueWhenCheckoutTheBook() {
        Menu mainMenu = new Menu();
        boolean expected = true;
        String bookToCheckout = "Title1";
        assertThat(mainMenu.checkoutBook(bookToCheckout), is(true));
    }

    @Test //1.8 Success message on checkout of a book
    public void shouldReturnSuccessMessageWhenBookSucessfullyCheckout() {
        Menu mainMenu = new Menu();
        boolean checkoutResult = true;
        String expected = "Thank you! Enjoy the book";
        assertThat(mainMenu.getCheckoutedBookMessage(checkoutResult), is(expected));
    }

    @Test //1.9 Un-successful message on checkout of a book
    public void shouldReturnNotSuccessMessageWhenBookNotSuccessfullyCheckout() {
        Menu mainMenu = new Menu();
        boolean checkoutResult = false;
        String expected = "Sorry, that book is not available";
        assertThat(mainMenu.getCheckoutedBookMessage(checkoutResult), is(expected));
    }

    @Test //1.10 Return a book
    public void shouldReturnTrueWhenUserReturnTheBook() {
        Menu mainMenu = new Menu();
        boolean expected = true;
        /* checkout a book */
        String selectedBook = "Title1";
        assertThat(mainMenu.checkoutBook(selectedBook), is(true));
        assertThat(mainMenu.getBooksInShelf(), is(not(containsString(selectedBook))));

        /* then check for return */
        assertThat(mainMenu.returnBook(selectedBook), is(true));
        assertThat(mainMenu.getBooksInShelf(), is(containsString(selectedBook)));

    }

    @Test //1.11 Notified on successful return
    public void shouldReturnSuccessMessageWhenBookSuccessfullyReturned() {
        Menu mainMenu = new Menu();
        boolean returnResult = true;
        String expected = "Thank you for returning the book";
        assertThat(mainMenu.getReturnedBookMessage(returnResult), is(expected));
    }

    @Test //1.12 Notified on unsuccessful return
    public void shouldReturnNotSuccessMessageWhenBookNotSuccessfullyReturned() {
        Menu mainMenu = new Menu();
        boolean returnResult = false;
        String expected = "That is not a valid book to return.";
        assertThat(mainMenu.getReturnedBookMessage(returnResult), is(expected));
    }

    @Test //2.1 View a list of available movies
    public void shouldReturnAllMovieDetailWhenNeeded() {
        Menu mainMenu = new Menu();
        String movie1Title = "Black Widow";
        String movie2Title = "Godzilla vs. Kong";
        String movie3Title = "Oxygen";
        String movie4Title = "No Time to Die";
        String movie1Year = "2021";
        String movie2Year = "2021";
        String movie3Year = "2021";
        String movie4Year = "2021";
        String movie1Director = "Cate Shortland";
        String movie2Director = "Adam Wingard";
        String movie3Director = "Alexandre Aja";
        String movie4Director = "Cary Joji Fukunaga";
        String movie1Rating = "7";
        String movie2Rating = "6";
        String movie3Rating = "7";
        String movie4Rating = "Unrated";
        assertThat(mainMenu.getMovieShelf(), is(allOf(
                containsString(movie1Title),
                containsString(movie2Title),
                containsString(movie3Title),
                containsString(movie4Title),
                containsString(movie1Year),
                containsString(movie2Year),
                containsString(movie3Year),
                containsString(movie4Year),
                containsString(movie1Director),
                containsString(movie2Director),
                containsString(movie3Director),
                containsString(movie4Director),
                containsString(movie1Rating),
                containsString(movie2Rating),
                containsString(movie3Rating),
                containsString(movie4Rating)
        )));
    }

    @Test //2.2 Checout a movie
    public void shouldReturnTrueWhenCheckoutMovie(){
        Menu mainMenu = new Menu();
        boolean expected = true;
        String movieToCheckout = "Black Widow";
        assertThat(mainMenu.checkoutMovie(movieToCheckout), is(true));
    }
}
