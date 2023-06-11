package com.librarysyndicate.an.controller;

import com.librarysyndicate.an.entity.Book;
import com.librarysyndicate.an.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookWebService {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId) {
        Book book = bookRepository.findById(bookId).get();
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        Book temp = new Book();
        Book newBook = bookRepository.save(book);
        return new ResponseEntity<>(newBook, HttpStatus.ACCEPTED);
    }

}
