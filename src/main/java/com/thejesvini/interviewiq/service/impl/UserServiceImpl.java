package com.thejesvini.interviewiq.service.impl;

import com.thejesvini.interviewiq.dto.LoginRequest;
import com.thejesvini.interviewiq.dto.RegisterRequest;
import com.thejesvini.interviewiq.entity.User;
import com.thejesvini.interviewiq.enums.Role;
import com.thejesvini.interviewiq.repository.UserRepository;
import com.thejesvini.interviewiq.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository,
                           PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(RegisterRequest request) {

        if(repository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .enabled(true)
                .build();

        return repository.save(user);
    }

    @Override
    public String login(LoginRequest request) {

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid Password");
        }

        return "Login Successful";
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {

        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}