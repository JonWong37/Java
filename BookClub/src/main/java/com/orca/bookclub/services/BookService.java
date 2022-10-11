package com.orca.bookclub.services;


import com.orca.bookclub.models.Book;
import com.orca.bookclub.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookrepository) {
        this.bookRepository = bookrepository;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }
}

