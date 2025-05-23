package com.example.demo.service.repository;

import com.example.demo.service.entity.UserData;
import com.example.demo.service.entity.UserRegisterData;

public interface UserRepository {
    int addUser(UserRegisterData user);
    UserData getUser(int id);
}
