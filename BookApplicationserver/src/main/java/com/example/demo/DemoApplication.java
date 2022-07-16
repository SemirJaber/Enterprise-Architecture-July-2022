package com.example.demo;

import com.example.demo.DTOs.BookDTO;
import com.example.demo.Domain.Author;
import com.example.demo.Domain.Book;
import com.example.demo.Domain.BookCopies;
import com.example.demo.Repositories.BookRepository;
import com.example.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
	 private BookRepository repo;
	@Autowired
	private BookService service;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book b1=new Book(1,"111","fairfield");
		Book b2=new Book(2,"222","iowa");
		BookCopies c1=new BookCopies(3);
		BookCopies c2=new BookCopies(4);
		Author a1=new Author("semir");
		Author a2=new Author("mine");
		b1.addBookCopies(c1);
		b1.AddAuthors(a1);
		b2.addBookCopies(c2);
		b2.AddAuthors(a2);

		repo.save(b1);
		repo.save(b2);
	service.updateBook(b1,6);
	Book b3=repo.findByScanCode(1);
		System.out.println(b3);


	}
}
