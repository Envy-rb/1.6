package com.envy.library.controller;

import com.envy.library.controller.command.Command;
import com.envy.library.controller.command.impl.*;
import com.envy.library.entity.Book;
import com.envy.library.exception.AppServiceException;

import java.util.List;

public class Invoker {
    private static Invoker instance;

    private Command addBookCommand = new AddBookCommand();
    private Command findByAuthorCommand = new FindByAuthorCommand();
    private Command findByIdCommand = new FindByIdCommand();
    private Command removeBookCommand = new RemoveBookCommand();
    private Command sortByIdCommand = new SortByIdCommand();

    private Invoker() {

    }

    public static Invoker getInstance() {
        if (instance == null) {
            instance = new Invoker();
        }

        return instance;
    }

    public List<Book> addBook(Book book) throws AppServiceException {
        return addBookCommand.execute(book);
    }

    public List<Book> findByAuthor(String author) throws AppServiceException {
        return findByAuthorCommand.execute(author);
    }
    public List<Book> findById(int id) throws AppServiceException {
        return findByIdCommand.execute(id);
    }
    public List<Book> removeBook(Book book) throws AppServiceException {
        return removeBookCommand.execute(book);
    }
    public List<Book> sortById() throws AppServiceException {
        return sortByIdCommand.execute(null);
    }
}
