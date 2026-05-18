package com.communityhub.demo.user.service;

import com.communityhub.demo.user.entity.User;
import com.communityhub.demo.user.repository.UserRepository;


public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUser(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    public User registerUser(User user) {

        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        return repository.save(user);
    }

}
