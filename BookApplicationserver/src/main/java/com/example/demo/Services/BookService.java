package com.example.demo.Services;

import com.example.demo.Adapter.BookAdapter;
import com.example.demo.DTOs.BookDTO;
import com.example.demo.Domain.Book;
import com.example.demo.Domain.BookCopies;
import com.example.demo.Repositories.BookCopiesRepository;
import com.example.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
@Autowired
    private BookRepository repository;

@Autowired
private BookCopiesRepository bookcopyrepository;


    public void addBook(Book book){
      //  Book book= BookAdapter.getBookfromBooKDTO(bookdto);
        repository.save(book);
    }
    public void updateBook(Book book,int numberofcopies){
       // List<BookDTO> bookdto=getBook(isbn);
        List<BookCopies> books=book.getCopies();
            for(BookCopies c:books){
                c.setQuantity(numberofcopies);
            }
        }
    public void removeBook(BookDTO bookdto){
        Book book= BookAdapter.getBookfromBooKDTO(bookdto);
        repository.delete(book);
    }
    public Book getBookbyisbn(String isbn){
        Book book=repository.findByIsbn(isbn);
       // BookDTO bookdto=BookAdapter.getBookDTOfromBook(book);
        return book;
    }
    public BookDTO getBookbyscancode(long scancode){
       Book book=repository.findByScanCode(scancode);
       BookDTO bookdto=BookAdapter.getBookDTOfromBook(book);
       return bookdto;
    }
    public BookDTO getBookbytitle(String title){
        Book book=repository.findByTitle(title);
        BookDTO bookdto=BookAdapter.getBookDTOfromBook(book);
        return bookdto;
    }
    public BookDTO getBookbyauthorname(String authorname){
        Book book=repository.findByAuthor(authorname);
        BookDTO bookdto=BookAdapter.getBookDTOfromBook(book);
        return bookdto;
    }
    public List<BookDTO> getAllBooks(){
        List<Book> books=repository.findAll();
        List<BookDTO> bookdtos=BookAdapter.getallBookDTOfromBook(books);
        return bookdtos;
    }
}
