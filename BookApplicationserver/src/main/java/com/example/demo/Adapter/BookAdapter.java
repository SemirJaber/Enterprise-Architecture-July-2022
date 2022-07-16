package com.example.demo.Adapter;

import com.example.demo.DTOs.BookCopiesDTO;
import com.example.demo.DTOs.BookDTO;
import com.example.demo.Domain.Author;
import com.example.demo.Domain.Book;
import com.example.demo.Domain.BookCopies;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter {

    public static BookDTO getBookDTOfromBook(Book book){
        BookDTO bookdto = new BookDTO(book.getIsbn(), book.getTitle());
     List<BookCopies> copies=book.getCopies();
     List<Author> authors=book.getAuthors();
     for(BookCopies c:copies){
         bookdto.addBookCopies(c);
     }
     for(Author e:authors){
         bookdto.addAuthor(e);
     }

        return bookdto;
    }


    public static Book getBookfromBooKDTO(BookDTO bookdto){
        Book book = new Book(bookdto.getIsbn(), bookdto.getTitle());
        List<BookCopies> books=book.getCopies();
        List<Author> author=book.getAuthors();
        for(BookCopies c:books){
            book.addBookCopies(c);
        }
        for(Author a:author){
            book. AddAuthors(a);
        }

        return book;
    }
    public static List<BookDTO> getallBookDTOfromBook(List<Book> books){
        List<BookDTO> bookdtos=new ArrayList<>();
        for(Book e:books){
             BookDTO b=getBookDTOfromBook(e);
             bookdtos.add(b);
        }
        return bookdtos;

    }
}
