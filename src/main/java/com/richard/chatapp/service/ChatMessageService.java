package com.richard.chatapp.service;

import com.richard.chatapp.entities.ChatDirection;
import com.richard.chatapp.entities.ChatMessage;
import com.richard.chatapp.repository.ChatMessageRepository;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
  private final ChatMessageRepository repository;
  private final ChatDirectionService chatDirectionService;

  public ChatMessage send(String message,Long sender_id,Long receiver_id) {
    ChatDirection messageDirection = chatDirectionService.getChatDirection(sender_id,receiver_id);
    ChatMessage chatMessage = ChatMessage.builder().chatDirection(messageDirection).content(message).time(new Date()).build();
    repository.save(chatMessage);
    return chatMessage;
  }

  public List<ChatMessage> findChatMessages(Long senderId, Long recipientId){
    ChatDirection chatDirection = chatDirectionService.getChatDirection(senderId,recipientId);
    return repository.findByChatId(chatDirection.getChatRoom().getId());
  }
}
