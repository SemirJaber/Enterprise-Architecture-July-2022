package com.example.demo.DTOs;



import java.util.ArrayList;
import java.util.List;

public class BookDTO {
    private String isbn;

    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthor(List<AuthorDTO> author) {
        this.authors = author;
    }

    public List<BookCopiesDTO> getCopies() {
        return copies;
    }

    private String title;
    private List<AuthorDTO> authors=new ArrayList<>();
    private List<BookCopiesDTO> copies=new ArrayList<>();

    public BookDTO(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAuthors(List<AuthorDTO> authors) {
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

    public void setCopies(List<BookCopiesDTO> copies) {
        this.copies = copies;
    }
    public void addBookCopies(BookCopiesDTO copy){
        copies.add(copy);
    }
    public void addAuthor(AuthorDTO author){
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
