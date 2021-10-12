package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    private Books bookShelf;
    private Movies movieShlef;
    private Users userList;
    private boolean userAlrLogin = false;
    private User user = null;
    Scanner sc = new Scanner(System.in);

    public Menu() {
        bookShelf = new Books();
        movieShlef = new Movies();
        userList = new Users();

    }

    public String getMenuOption() {
        String menuOption =
                "Main menu:" + "\n" +
                        "[1]: List of books" + "\n" +
                        "[2]: Checkout a book" + "\n" +
                        "[3]: Return a book" + "\n" +
                        "[4]: List of movies" + "\n" +
                        "[5]: Checkout a movie" + "\n" +
                        "[6]: return a movie" + "\n" +
                        "[7]: Login" + "\n" +
                        "[8]: View checkedout book (Login required)" + "\n" +
                        "[9]: view checkedout movie (Login required)" + "\n" +
                        "[10]: View user information" + "\n" +
                        "[11]: Logout" + "\n" +
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

    private boolean isUserLoggingin() {
        if (userAlrLogin) {
            return true;
        } else {
            System.out.println(getPleaseLoginFirstMessage());
            return false;
        }
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

    public boolean checkoutMovie(String movieToCheckout) {
        boolean checkoutResult = movieShlef.checkoutMovie(movieToCheckout);
        return checkoutResult;
    }

    public boolean checkUserLogin(User userToLogin) {
        User getUserInSystem = userList.login(userToLogin);
        boolean loginResult;
        if (getUserInSystem!=null){
            user=getUserInSystem;
            return true;
        }
        return false;
    }

    public User getUser() {
        String libraryNumber = sc.nextLine();
        String password = sc.nextLine();
        User userToLogin = new User(libraryNumber, password, "", "", "");
        return userToLogin;
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
                        userAlrLogin = userAbleToLogin;
                    } else {
                        System.out.println("Invalid library number or password!");
                    }
                } else {
                    System.out.println(getUserAlrLoginMessage());
                }
                break;
            case 8: // view checked out book
                if (isUserLoggingin()) {
                    System.out.println(user.getCheckedoutBook());
                }
                break;
            case 9: // view checked out movie
                if (isUserLoggingin()) {
                    System.out.println(user.getCheckedoutMovie());
                }
                break;
            case 10: // get user information
                if (isUserLoggingin()){
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
