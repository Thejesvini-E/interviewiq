package com.thejesvini.interviewiq.service;

import com.thejesvini.interviewiq.entity.User;
import com.thejesvini.interviewiq.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(User user) {

        if(repository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}