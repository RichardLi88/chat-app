package com.richard.chatapp.repository;

import com.richard.chatapp.entities.ChatDirection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatDirectionRepository extends JpaRepository<ChatDirection,Long> {

  @Query("SELECT c FROM ChatDirection WHERE c.sender.id = :senderId AND c.recipient.id = :recipientId")
  Optional<ChatDirection> findChatDirection(@Param("senderId") Long senderId,@Param("recipientId") Long recipientId);
}
