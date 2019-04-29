package ru.milovanov.dao.impl;

import ru.milovanov.dao.interfaces.BookDao;
import ru.milovanov.dao.objects.Book;

import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public List<Book> getByUsername(String username) {
        return null;
    }

    @Override
    public Book getOneByIsbn(String isbn) {
        return null;
    }

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public int delete(String isbn) {
        return 0;
    }
}
