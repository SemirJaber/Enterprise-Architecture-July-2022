package com.example.demo.DTOs;

import org.springframework.data.mongodb.core.mapping.Document;


public class BookCopiesDTO {
    @Override
    public String toString() {
        return "BookCopiesDTO{" +
                "scancode=" + scancode +
                ", quantity=" + quantity +
                '}';
    }

    private long scancode;
    private int quantity;

    public BookCopiesDTO(long scancode, int quantity) {
        this.scancode = scancode;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
