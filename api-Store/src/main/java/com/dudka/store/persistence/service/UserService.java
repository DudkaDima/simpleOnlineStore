package com.dudka.store.persistence.service;

import com.dudka.store.persistence.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    List<User> findByEmail(String email);

    List<User> findByPhone(String phone);

    void saveUser(User user);

}
