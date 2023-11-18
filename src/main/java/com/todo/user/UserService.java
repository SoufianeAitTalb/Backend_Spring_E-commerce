package com.todo.user;

import com.todo.user.UserItem;
import com.todo.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static boolean checkLogin(String username, String password) {
        UserItem user = userRepository.findByname(username);
        if (user == null) {
            // handle case when user is not found
            return false;
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            return true;
        } else {
            // handle case when password is incorrect
            return false;
        }
    }
}