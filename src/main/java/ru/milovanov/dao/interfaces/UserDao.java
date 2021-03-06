package ru.milovanov.dao.interfaces;

import ru.milovanov.dao.objects.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getOne(String username);
    User create(User user);
    User update(User user);
    int delete(String username);
}
