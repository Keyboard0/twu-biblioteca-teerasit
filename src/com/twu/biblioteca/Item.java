package com.twu.biblioteca;

public class Item {
    private String title;
    private boolean isCheckout;

    public Item(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckout() {
        return this.isCheckout;
    }

    public void setCheckout(boolean checkout) {
        this.isCheckout = checkout;
    }
    public String getParent(){
        return this.getClass().getName();
    }
}
