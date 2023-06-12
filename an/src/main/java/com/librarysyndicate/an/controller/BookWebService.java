package com.librarysyndicate.an.controller;

import com.librarysyndicate.an.entity.Book;
import com.librarysyndicate.an.repository.BookRepository;
import com.librarysyndicate.an.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookWebService {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        Book newBook = bookService.saveBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/{bookId}")
    public ResponseEntity<?> updateBookById(@PathVariable Long bookId, @RequestBody Book book) {
        Book updatedBook = bookService.updateBookById(bookId, book);
        return new ResponseEntity<>(updatedBook, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{bookId}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
