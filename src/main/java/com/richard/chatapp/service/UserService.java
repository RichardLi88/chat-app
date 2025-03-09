package com.richard.chatapp.service;

import com.richard.chatapp.repository.UserRepository;
import com.richard.chatapp.entities.Status;
import com.richard.chatapp.entities.User;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;
  public void setOnlineUser(User user) {
    user.setStatus(Status.ONLINE);
    repository.save(user);
  }

  public User saveUser(User user) {
    user.setStatus(Status.OFFLINE);
    return repository.save(user);
  }

  public void disconnect(User user) {
    Optional<User> storedUser = repository.findById(user.getId());
    if (storedUser.isPresent()) {
      storedUser.get().setStatus(Status.OFFLINE);
      repository.save(storedUser.get());
    }
  }

  public List<User> findOnlineUsers(){
    return repository.findAllByStatus(Status.ONLINE);
  }

  public User findById(Long id) {
    Optional<User> user = repository.findById(id);
    return user.orElse(null);
  }

  public User findByUsername(String username) {
    Optional<User> user = repository.findByUsername(username);
    return user.orElse(null);
  }
}

