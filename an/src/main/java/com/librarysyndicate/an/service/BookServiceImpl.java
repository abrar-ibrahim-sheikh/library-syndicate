package com.librarysyndicate.an.service;

import com.librarysyndicate.an.entity.Book;
import com.librarysyndicate.an.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
//        Book newBook = new Book();
//        newBook.setId(book.getId());
//        newBook.setDescription(book.getDescription());
//        newBook.setTitle(book.getTitle());
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBookById(Long id, Book book) {
        Book updateBook = new Book();
        updateBook.setId(id);
        updateBook.setTitle(book.getTitle());
        updateBook.setDescription(book.getDescription());
        return bookRepository.save(updateBook);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

}
