package com.example.demo.BookClient;



import java.util.ArrayList;
import java.util.List;

public class Book {

    private long id;
    private String isbn;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", copies=" + copies +
                '}';
    }

    private String title;
    private List<Author> authors=new ArrayList<>();
    private List<BookCopies> copies=new ArrayList<>();

   public Book(){}
    public List<Author> getAuthors() {
        return authors;
    }
    public void addBookCopies(BookCopies copy){
        copies.add(copy);
    }

    public Book(long id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;

    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public List<BookCopies> getCopies() {
        return copies;
    }
  public void AddBookCopies(BookCopies copy){
        copies.add(copy);
  }
  public void AddAuthors(Author author){
        authors.add(author);
  }






}
