package com.richard.chatapp.service;

import com.richard.chatapp.entities.ChatDirection;
import com.richard.chatapp.entities.ChatMessage;
import com.richard.chatapp.entities.ChatRoom;
import com.richard.chatapp.entities.User;
import com.richard.chatapp.repository.ChatDirectionRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatDirectionService {
  private ChatDirectionRepository repository;
  private ChatRoomService chatRoomService;
  private UserService userService;

  public ChatDirection getChatDirection(Long sender_id,Long recipient_id) {
    Optional<ChatDirection> chatDirection =  repository.findChatDirection(sender_id,recipient_id);
    return chatDirection.orElseGet(() -> createChatDirection(sender_id, recipient_id));
  }

  private ChatDirection createChatDirection(Long sender_id, Long recipient_id) {
    ChatRoom newChatRoom = chatRoomService.createChatRoom(String.format("Room for %s and %s", sender_id, recipient_id));
    User senderUser = userService.findById(sender_id);
    User recipientUser = userService.findById(recipient_id);
    if (senderUser != null && recipientUser != null) {
      ChatDirection senderChatDirection = ChatDirection.builder().sender(senderUser).recipient(recipientUser).build();
      ChatDirection recipientChatDirection = ChatDirection.builder().sender(recipientUser).recipient(senderUser).build();
      this.save(recipientChatDirection);
      this.save(senderChatDirection);
      return senderChatDirection;
    }
    return null;
  }

  private ChatDirection save(ChatDirection chatDirection) {
    repository.save(chatDirection);
    return chatDirection;
  }

}
