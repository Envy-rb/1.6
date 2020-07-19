package com.envy.library.dao;

import com.envy.library.entity.Book;
import com.envy.library.exception.AppDaoException;

import java.util.List;
import java.util.Optional;

public interface ListDao {
    List<Book> add(Book book) throws AppDaoException;

    List<Book> remove(Book book) throws AppDaoException;

    Optional<Book> findById(int bookId);

    List<Book> findAll();

    List<Book> findByAuthor(String author);

    List<Book> sortById();

}
