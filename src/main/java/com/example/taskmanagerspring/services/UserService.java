package com.example.taskmanagerspring.services;

import com.example.taskmanagerspring.models.User;
import com.example.taskmanagerspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register( String username, String password) {
        if (userRepository.findByUsername(username).isPresent()){
            throw new RuntimeException("Пользователь уже существует");
        }

        String encodedPassword = password;

        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

}
