package com.example.demo.service;


import com.example.demo.service.entity.UserData;
import com.example.demo.service.entity.UserRegisterData;
import com.example.demo.service.repository.UserRepository;

public class UserService {
    UserRepository repository;
    public UserService(UserRepository userRepository) {
        repository = userRepository;
    }

    public UserData getUserInfo(int id)
    {
        // AuthService.get ...

        return null;
    }

    public boolean addUser(UserRegisterData data) {
        // 1. Валидация

        // 2. Логика
        repository.addUser(data);

        //Создание ответа

        return true;
    }
}
