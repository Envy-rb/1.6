package com.envy.library;

import com.envy.library.creator.BookCreator;
import com.envy.library.entity.Book;
import com.envy.library.exception.AppServiceException;
import com.envy.library.service.impl.BookManagementServiceImpl;

import java.io.Console;

public class Main {

    public static void main(String[] args) throws AppServiceException {
        BookManagementServiceImpl service = new BookManagementServiceImpl();
        BookCreator creator = new BookCreator();
        service.addBook(creator.createBook("Компьютерные сети, Эндрю Таненбаум, HARD").get());
        service.addBook(creator.createBook("Архитектура компьютера, Эндрю Таненбаум, SOFT").get());
        service.addBook(creator.createBook("Микросервисы и контейнеры Docker, Парминдер Сингх Кочер, SOFT").get());

        System.out.println(service.findById(2));

        for (Book book : service.sortById()) {
            System.out.println(book);
        }

        Book bookById = service.findById(1).get();

        for (Book book : service.removeBook(bookById)) {
            System.out.println(book);
        }

        service.addBook(creator.createBook("Микросервисы и контейнеры Docker расширенное, Парминдер Сингх Кочер, SOFT").get());

        for (Book book : service.sortById()) {
            System.out.println(book);
        }
    }
}
