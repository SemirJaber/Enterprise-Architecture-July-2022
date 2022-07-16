package com.example.demo.Adapter;

import com.example.demo.DTOs.BookCopiesDTO;
import com.example.demo.Domain.BookCopies;

public class BookCopiesAdapter {

    public BookCopiesDTO getBookCopiesDTOfromBookCopies(BookCopies bookcopies){
       return new BookCopiesDTO(bookcopies.getScancode(),bookcopies.getQuantity());
    }
    public BookCopies getBookCopiesfromBookCopiesDTO(BookCopies bookcopies){
        return new BookCopies(bookcopies.getQuantity());
    }

}
