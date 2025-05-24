package com.example.demo.repository.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

public class InMemoryUserRepository implements UserRepository {
    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public User getUser(int id) {
        return null;
    }
}