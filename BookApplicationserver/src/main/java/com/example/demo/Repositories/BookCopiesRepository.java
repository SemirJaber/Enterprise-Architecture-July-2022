package com.example.demo.Repositories;

import com.example.demo.Domain.BookCopies;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookCopiesRepository extends MongoRepository<BookCopies,Long> {

    //BookCopies findByScancode(long scancode);
}
