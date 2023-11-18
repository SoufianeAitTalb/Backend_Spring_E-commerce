package com.todo.message;

import com.todo.Task.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<MessageItem,Long> {
}
