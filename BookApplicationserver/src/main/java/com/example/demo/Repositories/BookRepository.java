package com.example.demo.Repositories;

import com.example.demo.Domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book,Long> {

        Book findByIsbn(String isbn);
        Book findByTitle(String title);


        @Query("{ 'authors': { $elemMatch: { 'name' : :#{#authorname} } }}")
        Book findByAuthor(@Param("authorname") String authorname);

        @Query("{ 'copies': { $elemMatch: { 'scancode' : ?0 } }}")
        Book findByScanCode(@Param ("scancode") long scancode);

//        @Query("{ 'grades': { $elemMatch: { 'courseName' : ?0 , 'grade' : ?1} }}")
//
//        @Query("{ 'grades': { $elemMatch: { 'courseName' : ?0 } }}")
}
