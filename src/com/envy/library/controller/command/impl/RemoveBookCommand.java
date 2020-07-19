package com.envy.library.controller.command.impl;

import com.envy.library.controller.command.Command;
import com.envy.library.entity.Book;
import com.envy.library.exception.AppServiceException;
import com.envy.library.service.impl.BookManagementServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class RemoveBookCommand implements Command {
    BookManagementServiceImpl service = new BookManagementServiceImpl();

    @Override
    public List<Book> execute(Object parameter) throws AppServiceException {
        List<Book> result = new ArrayList<>();

        result = service.removeBook((Book)parameter);
        return result;
    }
}
