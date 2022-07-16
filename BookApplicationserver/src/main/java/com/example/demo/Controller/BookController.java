package com.example.demo.Controller;

import com.example.demo.DTOs.BookDTO;
import com.example.demo.Domain.Book;
import com.example.demo.Repositories.BookRepository;
import com.example.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

   @Autowired
    private BookService bookservice;
   @Autowired
   private BookRepository bookrepo;

@PostMapping("/books")
   public ResponseEntity<?> addBook(@RequestBody Book book ){
       bookservice.addBook(book);
       return new ResponseEntity<Book>(book, HttpStatus.OK);
   }
   @DeleteMapping("/books")
   public ResponseEntity<?> deleteBook(@RequestBody BookDTO bookdto){
    bookservice.removeBook(bookdto);
    return new ResponseEntity<BookDTO>(bookdto,HttpStatus.OK);
   }
   @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn){
    Book book=bookservice.getBookbyisbn(isbn);
        return new ResponseEntity<Book>(book,HttpStatus.OK);

    }
//    @GetMapping("/books/{scancode}")
//    public ResponseEntity<?> getBook(@PathVariable long scancode){
//      BookDTO book=bookservice.getBookbyscancode(scancode);
//      return new ResponseEntity<BookDTO>(book,HttpStatus.OK);
//
//    }
    @PutMapping("/books/{quantity}")
   public ResponseEntity<?> updateBook(@RequestBody Book book,@PathVariable int quantity){
        bookservice.updateBook(book,quantity);
        return new ResponseEntity<Book>(book,HttpStatus.OK);
  }
  @GetMapping("/books")
  public ResponseEntity<?> getAllBooks(){
    List<BookDTO> list=bookservice.getAllBooks();
    return new ResponseEntity<List<BookDTO>>(list,HttpStatus.OK);

  }
}
