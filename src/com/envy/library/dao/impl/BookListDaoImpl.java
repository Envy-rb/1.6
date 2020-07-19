package com.envy.library.dao.impl;

import com.envy.library.dao.ListDao;
import com.envy.library.entity.Book;
import com.envy.library.entity.Storage;
import com.envy.library.exception.AppDaoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BookListDaoImpl implements ListDao {
    @Override
    public List<Book> add(Book book) throws AppDaoException {
        boolean addingResult = Storage.getInstance().addBook(book);

        if(!addingResult){
            throw new AppDaoException("Error while adding book to storage");
        }

        List<Book> bookList = Storage.getInstance().getBooks();

        return bookList;
    }

    @Override
    public List<Book> remove(Book book) throws AppDaoException {
        if(!Storage.getInstance().removeBook(book)){
            throw new AppDaoException("Error while removing book from storage");
        }

        List<Book> bookList = Storage.getInstance().getBooks();

        return bookList;
    }

    @Override
    public Optional<Book> findById(int bookId) {
        List<Book> books = Storage.getInstance().getBooks();
        Optional<Book> targetBook = Optional.empty();

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                targetBook = Optional.of(book);
                break;
            }
        }

        return targetBook;
    }

    @Override
    public List<Book> findAll() {
        List<Book> targetBooks = Storage.getInstance().getBooks();

        return targetBooks;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> books = Storage.getInstance().getBooks();
        List<Book> targetBooks = new ArrayList<>();

        for (Book book : books) {
            String bookAuthor = book.getAuthor();
            if (bookAuthor == author) {
                targetBooks.add(book);
            }
        }

        return targetBooks;
    }

    @Override
    public List<Book> sortById() {
        List<Book> books = Storage.getInstance().getBooks();
        List<Book> sortedBooks = new ArrayList<>(books);

        sortedBooks.sort(Comparator.comparingInt(Book::getBookId));

        return sortedBooks;
    }
}
