package com.spring_boot.mart.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_boot.mart.account.entity.User;

@Service
public interface UserService {
    User findUserByUsername(String username, String password);
    List<User> findAllUsers();
}
