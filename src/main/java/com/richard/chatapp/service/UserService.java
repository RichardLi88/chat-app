package com.richard.chatapp.service;

import com.richard.chatapp.repository.UserRepository;
import com.richard.chatapp.user.Status;
import com.richard.chatapp.user.User;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;
  public void saveUser(User user) {
    user.setStatus(Status.ONLINE);
    repository.save(user);
  }

  public void disconnect(User user) {
    Optional<User> storedUser = repository.findById(user.getId());
    if (storedUser.isPresent()) {
      storedUser.get().setStatus(Status.OFFLINE);
      repository.save(storedUser.get());
    }
  }

  public List<User> findOnlineUsers(){
    return repository.findAllOnline();
  }
}

