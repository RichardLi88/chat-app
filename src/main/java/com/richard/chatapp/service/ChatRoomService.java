package com.richard.chatapp.service;

import com.richard.chatapp.entities.ChatRoom;
import com.richard.chatapp.repository.ChatRoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
@Controller
public class ChatRoomService {

  private ChatRoomRepository repository;

  public ChatRoom createChatRoom(String name) {
    ChatRoom chatRoom =  ChatRoom.builder().name("name").build();
    repository.save(chatRoom);
    return chatRoom;
  }
}
