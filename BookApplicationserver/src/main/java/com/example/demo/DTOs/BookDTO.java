package com.example.demo.DTOs;

import com.example.demo.Domain.Author;
import com.example.demo.Domain.BookCopies;

import java.util.ArrayList;
import java.util.List;

public class BookDTO {
    private String isbn;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthor(List<Author> author) {
        this.authors = author;
    }

    public List<BookCopies> getCopies() {
        return copies;
    }

    private String title;
    private List<Author> authors=new ArrayList<>();
    private List<BookCopies> copies=new ArrayList<>();

    public BookDTO(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCopies(List<BookCopies> copies) {
        this.copies = copies;
    }
    public void addBookCopies(BookCopies copy){
        copies.add(copy);
    }
    public void addAuthor(Author author){
        authors.add(author);
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", copies=" + copies +
                '}';
    }
}
