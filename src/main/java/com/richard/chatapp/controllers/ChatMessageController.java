package com.richard.chatapp.controllers;

import com.richard.chatapp.entities.ChatMessage;
import com.richard.chatapp.entities.ChatNotification;
import com.richard.chatapp.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {
  private final SimpMessagingTemplate messagingTemplate;
  private final ChatMessageService chatMessageService;

  @MessageMapping("/chat")
  public void sendMessage(@Payload String message,@Header("senderId") Long senderId, @Header("recipientId") Long recipientId){
    ChatMessage savedMsg = chatMessageService.send(message,senderId,recipientId);
    messagingTemplate.convertAndSendToUser(savedMsg.getChatDirection().getRecipient().getUsername(),"/queue/messages",
        ChatNotification.builder().content(savedMsg.getContent()).senderId(savedMsg.getChatDirection().getSender().getId()).recipientId(
            savedMsg.getChatDirection().getRecipient().getId()).build());
  }
}
