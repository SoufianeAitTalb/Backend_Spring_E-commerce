package com.e_commerce.message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<MessageItem,Long> {
}
