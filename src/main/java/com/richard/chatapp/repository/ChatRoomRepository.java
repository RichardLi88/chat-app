package com.richard.chatapp.repository;

import com.richard.chatapp.entities.ChatRoom;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom,Long> {

  @Query("SELECT c FROM ChatRoom c WHERE c.sender.id = :senderId AND c.recipient.id = :recipientId")
  Optional<ChatRoom> findBySenderRecipientID(@Param("senderId") Long senderId,@Param("recipientId") Long recipientId);
}
