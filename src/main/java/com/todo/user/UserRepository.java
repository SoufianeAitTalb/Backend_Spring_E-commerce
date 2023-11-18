package com.todo.user;

import com.todo.user.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
//import org.mindrot.jbcrypt.BCrypt;
public interface UserRepository  extends JpaRepository<UserItem,Long> {
    UserItem findByname(String name);
}
