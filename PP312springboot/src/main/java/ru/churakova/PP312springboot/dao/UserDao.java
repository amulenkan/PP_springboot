package ru.churakova.PP312springboot.dao;

import ru.churakova.PP312springboot.models.User;
import java.util.List;

public interface UserDao {
    List<User> getUsers();

    public void saveUser(User user);

    public User getUser(Integer id);

    public void deleteUser(Integer id);
}
