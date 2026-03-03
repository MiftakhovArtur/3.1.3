package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);

    Role findByName(String name);

    List<Role> findAll();

    void delete(Role role);
}
