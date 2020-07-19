package com.envy.library.service;

import com.envy.library.entity.Book;
import com.envy.library.exception.AppServiceException;

import java.util.List;
import java.util.Optional;

public interface ManagementService {
    List<Book> addBook(Book book) throws AppServiceException;

    List<Book> removeBook(Book book) throws AppServiceException;

    Optional<Book> findById(int bookId);

    List<Book> findByAuthor(String author) throws AppServiceException;

    List<Book> sortById() throws AppServiceException;
}
