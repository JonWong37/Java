package com.orca.bookclub.repositories;


import com.orca.bookclub.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    // this method retrieves all the books from the database
    List<Book> findAll();
}