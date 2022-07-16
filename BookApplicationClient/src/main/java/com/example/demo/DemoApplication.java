package com.example.demo;
import com.example.demo.DTOs.BookDTO;
import com.example.demo.Domain.Author;
import com.example.demo.Domain.Book;
import com.example.demo.Domain.BookCopies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	 RestTemplate template=new RestTemplate();
	 private String serverUrl= "http://localhost:8081/books";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

       Book book= new Book("125", "Mary Jones");
//		template.postForLocation(serverUrl, new Book("135","Franky Jones"));

		// template.getForObject(serverUrl+"/books/book", BookDTO.class);
		System.out.println(book);
		Book b1=new Book(3,"122","des moines");
		BookCopies c1=new BookCopies(3);
		Author a1=new Author("morgan");

		b1.addBookCopies(c1);
		b1.AddAuthors(a1);

		template.postForLocation(serverUrl,b1);

	}
}
