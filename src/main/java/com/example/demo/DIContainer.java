package com.example.demo;

import com.example.demo.repository.InMemoryUserRepo;
import com.example.demo.service.UserService;
import com.example.demo.service.repository.UserRepository;

public class DIContainer {

    public static final DIContainer instance = new DIContainer();

    UserRepository userRepository;
    UserService userService;

    public DIContainer()
    {
        userRepository = new InMemoryUserRepo();

        userService = new UserService(userRepository);
        //userService.setUserRepository
        //setAuthService
    }

    public UserService getUserService() {
        return userService;
    }
}
