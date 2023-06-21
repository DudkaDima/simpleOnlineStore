package com.dudka.store.persistence.service.implementation;

import com.dudka.store.persistence.entity.User;
import com.dudka.store.persistence.repository.UserRepository;
import com.dudka.store.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional


public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByEmail(String email) {
        return null;
    }

    @Override
    public List<User> findByPhone(String phone) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
