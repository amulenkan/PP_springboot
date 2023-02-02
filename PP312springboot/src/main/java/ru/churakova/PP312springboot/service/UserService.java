package ru.churakova.PP312springboot.service;


import ru.churakova.PP312springboot.models.User;
import java.util.List;


public interface UserService {
    List<User> getUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
