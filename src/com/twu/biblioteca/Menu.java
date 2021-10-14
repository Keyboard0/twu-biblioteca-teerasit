package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    private final Books bookShelf;
    private final Movies movieShelf;
    private final Users userList;
    private boolean userAlrLogin = false;
    private User user = null;
    Scanner sc = new Scanner(System.in);

    public Menu() {
        bookShelf = new Books();
        movieShelf = new Movies();
        userList = new Users();

    }

    public String getMenuOption() {
        return """
                Main menu:
                [1]: List of books
                [2]: Checkout a book
                [3]: Return a book
                [4]: List of movies
                [5]: Checkout a movie
                [6]: return a movie
                [7]: Login
                [8]: View checkedout book (Login required)
                [9]: view checkedout movie (Login required)
                [10]: View user information (Login required)
                [11]: Logout
                [0]: Quit""";
    }

    public String getWelcome() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String getInvalidMessage() {
        return "Please select a valid option!";
    }

    public String getExitMessage() {
        return "Thank you for using our application. Exiting the application. Goodbye";
    }

    public String getPleaseEnterUserToLoginMessage() {
        return "Please enter library number and password to login";
    }

    private String getUserAlrLoginMessage() {
        return "User already logged in.";
    }

    private String getPleaseLoginFirstMessage() {
        return "Please login first.";
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

    public String getCheckoutedMovieMessage(boolean checkedOutResult) {
        if (checkedOutResult) {
            return "Thank you! Enjoy the movie";
        } else {
            return "Sorry, that movie is not available";
        }
    }

    public String getReturnedMovieMessage(boolean returnResult) {
        if (returnResult) {
            return "Thank you for returning the movie";
        } else {
            return "That is not a valid movie to return.";
        }
    }

    public boolean checkoutBook(String bookToCheckout) {
        return bookShelf.checkoutTheBook(bookToCheckout);
    }

    public boolean checkoutMovie(String movieToCheckout) {
        return movieShelf.checkoutMovie(movieToCheckout);
    }

    public boolean returnBook(String bookToReturn) {
        return bookShelf.returnTheBook(bookToReturn);
    }

    public boolean returnMovie(String movieToReturn) {
        return movieShelf.returnMovie(movieToReturn);
    }

    public String getBooksInShelf() {
        StringBuilder allBook = new StringBuilder();
        for (Book book : bookShelf.getListBook()) {
            allBook.append(book.getBookInfo()).append("\n");
        }
        return allBook.toString();
    }

    public String getMovieShelf() {
        StringBuilder allMovies = new StringBuilder();
        for (Movie movie : movieShelf.getMovieShelf()) {
            allMovies.append(movie.getMovieInfo()).append("\n");
        }
        return allMovies.toString();
    }

    private boolean isUserLoggingin() {
        if (userAlrLogin) {
            return true;
        } else {
            System.out.println(getPleaseLoginFirstMessage());
            return false;
        }
    }

    public boolean checkUserLogin(User userToLogin) {
        User getUserInSystem = userList.login(userToLogin);
        if (getUserInSystem != null) {
            user = getUserInSystem;
            return true;
        }
        return false;
    }

    public User getUser() {
        String libraryNumber = sc.nextLine();
        String password = sc.nextLine();
        return new User(libraryNumber, password, "", "", "");
    }

    public void start() {
        System.out.println(getWelcome());
        int userChoice;
        do {
            System.out.println(getMenuOption());
            userChoice = Integer.parseInt(sc.nextLine());
            userSelect(userChoice);
        } while (userChoice != 0);
    }

    public void userSelect(int userChoice) {
        switch (userChoice) {
            case 1: // List of books
                System.out.println(getBooksInShelf());
                break;
            case 2: // checkout a book
                if (isUserLoggingin()) {
                    System.out.println("Please enter book title to check out");
                    String bookToCheckout = sc.nextLine();
                    boolean ableToCheckout = checkoutBook(bookToCheckout);
                    if (ableToCheckout) {
                        user.addBook(bookToCheckout);
                    }
                    System.out.println(getCheckoutedBookMessage(ableToCheckout));
                }
                break;
            case 3: // return a book
                if (isUserLoggingin()) {
                    System.out.println("Please enter book title to return");
                    String bookToReturn = sc.nextLine();
                    boolean ableToReturn = returnBook(bookToReturn);
                    if (ableToReturn) {
                        user.removeBook(bookToReturn);
                    }
                    System.out.println(getReturnedBookMessage(returnBook(bookToReturn)));
                }
                break;
            case 4: // list of movies
                System.out.println(getMovieShelf());
                break;
            case 5: // checkout a movie
                if (isUserLoggingin()) {
                    System.out.println("Please enter movie title to check out");
                    String movieToCheckout = sc.nextLine();
                    boolean ableToCheckout = checkoutMovie(movieToCheckout);
                    if (ableToCheckout) {
                        user.addMovie(movieToCheckout);
                    }
                    System.out.println(getCheckoutedMovieMessage(ableToCheckout));
                }
                break;
            case 6: // return a movie
                if (isUserLoggingin()) {
                    System.out.println("Please enter movie title to return");
                    String movieToReturn = sc.nextLine();
                    boolean ableToReturn = checkoutMovie(movieToReturn);
                    if (ableToReturn) {
                        user.removeMovie(movieToReturn);
                    }
                    System.out.println(getReturnedMovieMessage(ableToReturn));
                }
                break;
            case 7: // User Login
                if (!userAlrLogin) {
                    System.out.println(getPleaseEnterUserToLoginMessage());
                    user = getUser();
                    boolean userAbleToLogin = checkUserLogin(user);
                    if (userAbleToLogin) {
                        System.out.println("Welcome");
                        userAlrLogin = true;
                    } else {
                        System.out.println("Invalid library number or password!");
                    }
                } else {
                    System.out.println(getUserAlrLoginMessage());
                }
                break;
            case 8: // view checked out book
                if (isUserLoggingin()) {
                    System.out.println(user.getCheckoutsBook());
                }
                break;
            case 9: // view checked out movie
                if (isUserLoggingin()) {
                    System.out.println(user.getCheckoutsMovie());
                }
                break;
            case 10: // get user information
                if (isUserLoggingin()) {
                    System.out.println(user.getInformation());
                }
                break;
            case 11: // logout
                if (isUserLoggingin()) {
                    userAlrLogin = false;
                    user = null;
                }
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
