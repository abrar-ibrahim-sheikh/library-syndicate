package com.librarysyndicate.an.service;

import com.librarysyndicate.an.entity.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    Book getBookById(Long id);

    List<Book> getAllBooks();

    Book updateBookById(Long id, Book book);

    void deleteBookById(Long id);

}
