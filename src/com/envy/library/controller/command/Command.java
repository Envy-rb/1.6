package com.envy.library.controller.command;

import com.envy.library.entity.Book;
import com.envy.library.exception.AppServiceException;

import java.util.List;

public interface Command {
    List<Book> execute(Object parameter) throws AppServiceException;
}
