package io.javabrains.springsecurityjwt.service;

import io.javabrains.springsecurityjwt.model.Users;
import io.javabrains.springsecurityjwt.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserRepository userRepository;

    private UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Users loadUserByUsername (String username){
        return userRepository.findByUsername(username);
    }
}
