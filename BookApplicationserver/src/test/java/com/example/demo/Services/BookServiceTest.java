package com.example.demo.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.DTOs.BookDTO;
import com.example.demo.Domain.Author;
import com.example.demo.Domain.Book;
import com.example.demo.Domain.BookCopies;
import com.example.demo.Repositories.BookCopiesRepository;
import com.example.demo.Repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookService.class})
@ExtendWith(SpringExtension.class)
class BookServiceTest {
    @MockBean
    private BookCopiesRepository bookCopiesRepository;

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;


    @Test
    void testAddBook() {
        Book book = new Book();
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        when(bookRepository.save((Book) any())).thenReturn(book);

        Book book1 = new Book();
        book1.AddAuthors(new Author("Name"));
        book1.addBookCopies(new BookCopies(1));
        book1.setIsbn("Isbn");
        book1.setTitle("Dr");
        bookService.addBook(book1);
        verify(bookRepository).save((Book) any());
        assertEquals(1, book1.getAuthors().size());
        assertEquals("Dr", book1.getTitle());
        assertEquals(1, book1.getCopies().size());
        assertEquals("Isbn", book1.getIsbn());
        assertTrue(bookService.getAllBooks().isEmpty());
    }


    @Test
    @Disabled("TODO: Complete this test")
    void testAddBook2() {


        BookService bookService = new BookService();

        Book book = new Book();
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        bookService.addBook(book);
    }


    @Test
    @Disabled("TODO: Complete this test")
    void testAddBook3() {

        BookService bookService = new BookService();
        Book book = mock(Book.class);
        doNothing().when(book).AddAuthors((Author) any());
        doNothing().when(book).addBookCopies((BookCopies) any());
        doNothing().when(book).setIsbn((String) any());
        doNothing().when(book).setTitle((String) any());
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        bookService.addBook(book);
    }


    @Test
    void testUpdateBook() {
        Book book = new Book();
        book.AddAuthors(new Author());
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        bookService.updateBook(book, 10);
        assertEquals(10, book.getCopies().get(0).getQuantity());
    }


    @Test
    void testUpdateBook2() {
        Book book = mock(Book.class);
        when(book.getCopies()).thenReturn(new ArrayList<>());
        doNothing().when(book).AddAuthors((Author) any());
        doNothing().when(book).addBookCopies((BookCopies) any());
        doNothing().when(book).setIsbn((String) any());
        doNothing().when(book).setTitle((String) any());
        book.AddAuthors(new Author());
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        bookService.updateBook(book, 10);
        verify(book).getCopies();
        verify(book).AddAuthors((Author) any());
        verify(book).addBookCopies((BookCopies) any());
        verify(book).setIsbn((String) any());
        verify(book).setTitle((String) any());
    }


    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateBook3() {


        ArrayList<BookCopies> bookCopiesList = new ArrayList<>();
        bookCopiesList.add(null);
        Book book = mock(Book.class);
        when(book.getCopies()).thenReturn(bookCopiesList);
        doNothing().when(book).AddAuthors((Author) any());
        doNothing().when(book).addBookCopies((BookCopies) any());
        doNothing().when(book).setIsbn((String) any());
        doNothing().when(book).setTitle((String) any());
        book.AddAuthors(new Author());
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        bookService.updateBook(book, 10);
    }


    @Test
    void testUpdateBook4() {
        Book book = new Book();
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        bookService.updateBook(book, 10);
        assertEquals(10, book.getCopies().get(0).getQuantity());
    }


    @Test
    void testUpdateBook5() {
        Book book = mock(Book.class);
        when(book.getCopies()).thenReturn(new ArrayList<>());
        doNothing().when(book).AddAuthors((Author) any());
        doNothing().when(book).addBookCopies((BookCopies) any());
        doNothing().when(book).setIsbn((String) any());
        doNothing().when(book).setTitle((String) any());
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        bookService.updateBook(book, 10);
        verify(book).getCopies();
        verify(book).AddAuthors((Author) any());
        verify(book).addBookCopies((BookCopies) any());
        verify(book).setIsbn((String) any());
        verify(book).setTitle((String) any());
    }


    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateBook6() {


        ArrayList<BookCopies> bookCopiesList = new ArrayList<>();
        bookCopiesList.add(null);
        Book book = mock(Book.class);
        when(book.getCopies()).thenReturn(bookCopiesList);
        doNothing().when(book).AddAuthors((Author) any());
        doNothing().when(book).addBookCopies((BookCopies) any());
        doNothing().when(book).setIsbn((String) any());
        doNothing().when(book).setTitle((String) any());
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        bookService.updateBook(book, 10);
    }


    @Test
    @Disabled("TODO: Complete this test")
    void testRemoveBook() {

        BookDTO bookdto = null;


        this.bookService.removeBook(bookdto);

    }


    @Test
    void testRemoveBook2() {
        doNothing().when(bookRepository).delete((Book) any());
        bookService.removeBook(new BookDTO("Isbn", "Dr"));
        verify(bookRepository).delete((Book) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testRemoveBook3() {


        doNothing().when(bookRepository).delete((Book) any());
        bookService.removeBook(null);
    }

    @Test
    void testGetBookbyisbn() {
        Book book = new Book();
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        when(bookRepository.findByIsbn((String) any())).thenReturn(book);
        assertSame(book, bookService.getBookbyisbn("Isbn"));
        verify(bookRepository).findByIsbn((String) any());
    }


    @Test
    void testGetBookbyscancode() {
        Book book = new Book();
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        when(bookRepository.findByScanCode(anyLong())).thenReturn(book);
        BookDTO actualBookbyscancode = bookService.getBookbyscancode(1L);
        assertEquals(1, actualBookbyscancode.getAuthors().size());
        assertEquals("Dr", actualBookbyscancode.getTitle());
        assertEquals(1, actualBookbyscancode.getCopies().size());
        assertEquals("Isbn", actualBookbyscancode.getIsbn());
        verify(bookRepository).findByScanCode(anyLong());
    }


    @Test
    void testGetBookbytitle() {
        Book book = new Book();
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        when(bookRepository.findByTitle((String) any())).thenReturn(book);
        BookDTO actualBookbytitle = bookService.getBookbytitle("Dr");
        assertEquals(1, actualBookbytitle.getAuthors().size());
        assertEquals("Dr", actualBookbytitle.getTitle());
        assertEquals(1, actualBookbytitle.getCopies().size());
        assertEquals("Isbn", actualBookbytitle.getIsbn());
        verify(bookRepository).findByTitle((String) any());
    }

    @Test
    void testGetBookbyauthorname() {
        Book book = new Book();
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");
        when(bookRepository.findByAuthor((String) any())).thenReturn(book);
        BookDTO actualBookbyauthorname = bookService.getBookbyauthorname("JaneDoe");
        assertEquals(1, actualBookbyauthorname.getAuthors().size());
        assertEquals("Dr", actualBookbyauthorname.getTitle());
        assertEquals(1, actualBookbyauthorname.getCopies().size());
        assertEquals("Isbn", actualBookbyauthorname.getIsbn());
        verify(bookRepository).findByAuthor((String) any());
    }


    @Test
    void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(bookService.getAllBooks().isEmpty());
        verify(bookRepository).findAll();
    }


    @Test
    void testGetAllBooks2() {
        Book book = new Book();
        book.AddAuthors(new Author("Name"));
        book.addBookCopies(new BookCopies(1));
        book.setIsbn("Isbn");
        book.setTitle("Dr");

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book);
        when(bookRepository.findAll()).thenReturn(bookList);
        List<BookDTO> actualAllBooks = bookService.getAllBooks();
        assertEquals(1, actualAllBooks.size());
        BookDTO getResult = actualAllBooks.get(0);
        assertEquals(1, getResult.getAuthors().size());
        assertEquals("Dr", getResult.getTitle());
        assertEquals(1, getResult.getCopies().size());
        assertEquals("Isbn", getResult.getIsbn());
        verify(bookRepository).findAll();
    }
}

