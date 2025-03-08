package com.richard.chatapp.repository;

import com.richard.chatapp.room.ChatRoom;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom,Long> {

  Optional<ChatRoom> findBySenderRecipientID(Long senderId, Long recipientId);
}
