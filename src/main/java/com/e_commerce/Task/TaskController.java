package com.e_commerce.Task;

import com.e_commerce.comments.Comments;
import com.e_commerce.comments.CommentsRepository;
import com.e_commerce.message.MessageItem;
import com.e_commerce.message.MessageRepository;
import com.e_commerce.user.UserItem;
import com.e_commerce.user.UserRepository;
import com.e_commerce.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentsRepository commentsRepository;
    @GetMapping
    public List<TaskItem> getTasks(){
        return taskRepository.findAll();
    }
    @GetMapping("/comments")
    public List<Comments> getComments(){
        return commentsRepository.findAll();
    }
    @GetMapping("/GU")
    public List<UserItem> getUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/add")
    public TaskItem addTask(@Valid @RequestBody TaskItem taskItem){
        return taskRepository.save(taskItem);
    }
    @PostMapping("/message")
    public MessageItem addMessage(@Valid @RequestBody MessageItem messageItem){
        return messageRepository.save(messageItem);
    }
    @PostMapping("/comments/add")
    public Comments addComments(@Valid @RequestBody Comments comments){
        return commentsRepository.save(comments);
    }
    @PostMapping("/user/add")
    public UserItem addUser(@Valid @RequestBody UserItem userItem){
        return userRepository.save(userItem);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTask(@PathVariable Long id, @RequestBody Map<String, Integer> TB){
        boolean exist = taskRepository.existsById(id);
        if(exist){
            TaskItem task = taskRepository.getById(id);
            int a =task.getTB();
//
            task.setTB(TB.get("TB")+a);
            taskRepository.save(task);
            return new ResponseEntity<>("Task is updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Task is not exist", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id){
        boolean exist = taskRepository.existsById(id);
        if(exist){
            taskRepository.deleteById(id);
            return new ResponseEntity<>("Task is deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Task is not exist", HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Boolean>> login(@RequestBody Map<String, String> body) {
        String username = body.get("name");
        String password = body.get("password");
        System.out.println(username+password);
        boolean isValid = UserService.checkLogin(username, password);
        Map<String, Boolean> response = new HashMap<>();
        response.put("isValid", isValid);
        return ResponseEntity.ok(response);
    }
}



//
//
//package com.todo.Task;
//
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.http.HttpStatus;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.web.bind.annotation.*;
//
//        import javax.validation.Valid;
//        import java.util.List;
//
//@RestController
//@RequestMapping(path = "/tasks")
//public class TaskController {
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    @GetMapping
//    public List<TaskItem> getTasks(){
//        return taskRepository.findAll();
//    }
//
//    @PostMapping("/add")
//    public TaskItem addTask(@Valid @RequestBody TaskItem taskItem){
//        return taskRepository.save(taskItem);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity updateTask(@PathVariable Long id){
//        boolean exist = taskRepository.existsById(id);
//        if(exist){
//            TaskItem task = taskRepository.getById(id);
//            boolean done = task.isDone();
//            task.setDone(!done);
//            taskRepository.save(task);
//            return new ResponseEntity<>("Task is updated", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Task is not exist", HttpStatus.BAD_REQUEST);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteTask(@PathVariable Long id){
//        boolean exist = taskRepository.existsById(id);
//        if(exist){
//            taskRepository.deleteById(id);
//            return new ResponseEntity<>("Task is deleted", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Task is not exist", HttpStatus.BAD_REQUEST);
//    }
//}
