package com.richard.chatapp.repository;

import com.richard.chatapp.user.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Query("SELECT user FROM users WHERE status = 0")
  List<User> findAllOnline();
}
