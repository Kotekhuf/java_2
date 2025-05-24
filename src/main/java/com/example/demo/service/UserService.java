package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public UserDto getUserInfo(int id) {
        User user = repository.getUser(id);
        if (user == null) {
            return null;
        }

        UserDto dto = new UserDto();
        dto.setId(user.getUserId());
        dto.setLogin(user.getUsername());
        return dto;
    }

    public boolean addUser(UserRegisterDto data) {
        // Валидация
        if (data.getLogin() == null || data.getLogin().isEmpty()) {
            return false;
        }

        // Преобразование DTO в Entity
        User user = new User();
        user.setUsername(data.getLogin());
        user.setPasswordHash(data.getPassword()); // В реальном приложении здесь должно быть хеширование

        // Сохранение
        repository.addUser(user);

        return true;
    }
}