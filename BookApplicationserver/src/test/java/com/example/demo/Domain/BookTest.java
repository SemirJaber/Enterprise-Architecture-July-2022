package com.example.demo.Domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class BookTest {
    /**
     * Method under test: {@link Book#Book()}
     */
    @Test
    void testConstructor() {
        Book actualBook = new Book();
        List<Author> authors = actualBook.getAuthors();
        assertTrue(authors.isEmpty());
        assertEquals(authors, actualBook.getCopies());
    }

    /**
     * Method under test: {@link Book#Book(long, String, String)}
     */
    @Test
    void testConstructor2() {
        Book actualBook = new Book(123L, "Isbn", "Dr");

        List<Author> authors = actualBook.getAuthors();
        assertTrue(authors.isEmpty());
        assertEquals("Dr", actualBook.getTitle());
        assertEquals("Isbn", actualBook.getIsbn());
        assertEquals(authors, actualBook.getCopies());
    }

    /**
     * Method under test: {@link Book#Book(String, String)}
     */
    @Test
    void testConstructor3() {
        Book actualBook = new Book("Isbn", "Dr");

        List<Author> authors = actualBook.getAuthors();
        assertTrue(authors.isEmpty());
        assertEquals("Dr", actualBook.getTitle());
        assertEquals("Isbn", actualBook.getIsbn());
        assertEquals(authors, actualBook.getCopies());
    }

    /**
     * Method under test: {@link Book#toString()}
     */
    @Test
    void testToString() {
        assertEquals("Book{id=0, isbn='null', title='null', authors=[], copies=[]}", (new Book()).toString());
    }

    /**
     * Method under test: {@link Book#getAuthors()}
     */
    @Test
    void testGetAuthors() {
        assertTrue((new Book()).getAuthors().isEmpty());
    }

    /**
     * Method under test: {@link Book#addBookCopies(BookCopies)}
     */
    @Test
    void testAddBookCopies2() {
        Book book = new Book();
        book.addBookCopies(new BookCopies(1));
        assertEquals(1, book.getCopies().size());
    }

    /**
     * Method under test: {@link Book#setIsbn(String)}
     */
    @Test
    void testSetIsbn() {
        Book book = new Book();
        book.setIsbn("Isbn");
        assertEquals("Isbn", book.getIsbn());
    }

    /**
     * Method under test: {@link Book#setTitle(String)}
     */
    @Test
    void testSetTitle() {
        Book book = new Book();
        book.setTitle("Dr");
        assertEquals("Dr", book.getTitle());
    }

    /**
     * Method under test: {@link Book#getIsbn()}
     */
    @Test
    void testGetIsbn() {
        assertNull((new Book()).getIsbn());
    }

    /**
     * Method under test: {@link Book#getTitle()}
     */
    @Test
    void testGetTitle() {
        assertNull((new Book()).getTitle());
    }

    /**
     * Method under test: {@link Book#getCopies()}
     */
    @Test
    void testGetCopies() {
        assertTrue((new Book()).getCopies().isEmpty());
    }

    /**
     * Method under test: {@link Book#AddBookCopies(BookCopies)}
     */
    @Test
    void testAddBookCopies() {
        Book book = new Book();
        book.AddBookCopies(new BookCopies(1));
        assertEquals(1, book.getCopies().size());
    }

    /**
     * Method under test: {@link Book#AddAuthors(Author)}
     */
    @Test
    void testAddAuthors() {
        Book book = new Book();
        book.AddAuthors(new Author("Name"));
        assertEquals(1, book.getAuthors().size());
    }
}

