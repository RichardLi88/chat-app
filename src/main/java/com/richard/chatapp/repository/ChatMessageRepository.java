package com.richard.chatapp.repository;

import com.richard.chatapp.entities.ChatMessage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {
  @Query("SELECT cm FROM ChatMessage cm " +
      "JOIN cm.chatDirection cd " +
      "JOIN cd.chatRoom cr " +
      "WHERE cr.id = :chatId")
  List<ChatMessage> findByChatId(@Param("chatId") Long id);
}
