package com.richard.chatapp.repository;

import com.richard.chatapp.entities.Status;
import com.richard.chatapp.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findAllByStatus(Status status);
}
