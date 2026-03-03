package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void updateUser(User user, List<String> roles);

    User findUserByUsername(String username);

    List<User> getAllUsers();

    void removeUser(Long id);

    User findOneById(Long id);
}
