package ru.kata.spring.boot_security.demo.repository;

import ru.kata.spring.boot_security.demo.models.User;
import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    User findByUsername(String username);
    void save(User user);
    void delete(Long id);
}
