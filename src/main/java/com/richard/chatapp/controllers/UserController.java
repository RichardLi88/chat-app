package com.richard.chatapp.controllers;


import com.richard.chatapp.service.UserService;
import com.richard.chatapp.entities.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService service;

  @MessageMapping("/user.addUser")
  @SendTo("/user/topic")
  public User addUser(@Payload User user) {
    service.setOnlineUser(user);
    return user;
  }

  @MessageMapping("/user.disconnectUser")
  @SendTo("/user/topic")
  public User disconnect(@Payload User user) {
    service.disconnect(user);
    return user;
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> findOnlineUsers(){
    return ResponseEntity.ok(service.findOnlineUsers());
  }

  @PostMapping("/get/user")
  public ResponseEntity<User> findUser(@RequestBody(required = true) User u){
    User user = service.findByUsername(u.getUsername());
    if (user == null) {
      User createUser = User.builder().username(u.getUsername()).firstName(u.getFirstName()).lastName(u.getLastName()).build();
      User newUser = service.saveUser(createUser);
      log.info(String.valueOf(newUser));
      return ResponseEntity.ok(newUser);
    }
    return ResponseEntity.ok(user);
  }
}
