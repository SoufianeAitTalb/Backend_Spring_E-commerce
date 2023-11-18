package com.e_commerce.user;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.mindrot.jbcrypt.BCrypt;
public interface UserRepository  extends JpaRepository<UserItem,Long> {
    UserItem findByname(String name);
}
