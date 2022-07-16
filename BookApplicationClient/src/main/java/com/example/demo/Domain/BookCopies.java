package com.example.demo.Domain;

public class BookCopies {

    private long scancode;
    private int quantity;

    public BookCopies(){}

    public BookCopies(long scancode, int quantity) {
        this.scancode = scancode;
        this.quantity = quantity;
    }

    public BookCopies(int quantity) {

        this.quantity = quantity;
    }

    public long getScancode() {
        return scancode;
    }

    public void setScancode(long scancode) {
        this.scancode = scancode;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "BookCopies{" +
                "scancode=" + scancode +
                ", quantity=" + quantity +
                '}';
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
