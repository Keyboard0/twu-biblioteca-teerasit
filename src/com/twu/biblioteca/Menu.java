package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    private Books bookShelf;
    private Movies movieShlef;
    Scanner sc = new Scanner(System.in);

    public Menu() {
        bookShelf = new Books();
        movieShlef = new Movies();
    }

    public String getMenuOption() {
        String menuOption =
                "Main menu:" + "\n" +
                        "[1]: List of books" + "\n" +
                        "[2]: Check out a book" + "\n" +
                        "[3]: Return a book" + "\n" +
                        "[4]: List of movies" + "\n" +

                        "[0]: Quit";
        return menuOption;
    }

    public String getWelcome() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String getBooksInShelf() {
        String allBook = "";
        for (Book book : bookShelf.getListBook()) {
            allBook += book.getBookInfo() + "\n";
        }
        return allBook;
    }

    public String getInvalidMessage() {
        return "Please select a valid option!";
    }

    public String getExitMessage() {
        return "Thank you for using our application. Exiting the application. Goodbye";
    }

    public String getCheckoutedBookMessage(boolean checkedOutResult) {
        if (checkedOutResult) {
            return "Thank you! Enjoy the book";
        } else {
            return "Sorry, that book is not available";
        }
    }

    public String getReturnedBookMessage(boolean returnResult) {
        if (returnResult) {
            return "Thank you for returning the book";
        } else {
            return "That is not a valid book to return.";
        }
    }

    public void start() {
        System.out.println(getWelcome());
        int userChoice;
        do {
            System.out.println(getMenuOption());
            userChoice = sc.nextInt();
            userSelect(userChoice);
        } while (userChoice != 0);
    }

    public boolean checkoutBook(String bookToCheckout) {
        boolean checkoutResult = bookShelf.checkoutTheBook(bookToCheckout);
        return checkoutResult;
    }

    public boolean returnBook(String bookToReturn) {
        boolean returnResult = bookShelf.returnTheBook(bookToReturn);
        return returnResult;
    }

    public String getMovieShelf() {
        String allMovies = "";
        for (Movie movie : movieShlef.getMovieShelf()) {
            allMovies += movie.getMovieInfo() + "\n";
        }
        return allMovies;
    }

    public boolean checkoutMovie(String movieToCheckout){
        boolean checkoutResult = movieShlef.checkoutMovie(movieToCheckout);
        return checkoutResult;
    }

    public void userSelect(int userChoice) {
        switch (userChoice) {
            case 1:
                System.out.println(getBooksInShelf());
                break;
            case 2:
                String bookToCheckout = sc.nextLine();
                System.out.println(getCheckoutedBookMessage(checkoutBook(bookToCheckout)));
                break;
            case 3:
                String bookToReturn = sc.nextLine();
                System.out.println(getReturnedBookMessage(returnBook(bookToReturn)));
                break;
            case 4:
                System.out.println(getMovieShelf());
                break;
            case 5:
                String movieToCheckout = sc.nextLine();
                System.out.println(checkoutMovie(movieToCheckout));
                break;
            case 0:
                System.out.println(getExitMessage());
                System.exit(0);
                break;
            default:
                System.out.println(getInvalidMessage());
                break;
        }
    }
}
