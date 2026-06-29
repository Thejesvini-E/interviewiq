package com.thejesvini.interviewiq.service;

import com.thejesvini.interviewiq.dto.LoginRequest;
import com.thejesvini.interviewiq.dto.RegisterRequest;
import com.thejesvini.interviewiq.entity.User;

import java.util.List;

public interface UserService {

    User register(RegisterRequest request);

    String login(LoginRequest request);

    List<User> getAllUsers();

    User getUserByEmail(String email);
}