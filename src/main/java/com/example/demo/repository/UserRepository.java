package com.example.demo.repository;

import com.example.demo.entity.User;

public interface UserRepository {
    int addUser(User user);
    User getUser(int id);
}