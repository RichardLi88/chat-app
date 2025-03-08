package com.richard.chatapp.repository;

import com.richard.chatapp.entities.ChatDirection;
import com.richard.chatapp.entities.ChatRoom;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom,Long> {
}
