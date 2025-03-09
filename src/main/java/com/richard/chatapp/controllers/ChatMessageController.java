package com.richard.chatapp.controllers;

import com.richard.chatapp.entities.ChatMessage;
import com.richard.chatapp.entities.ChatNotification;
import com.richard.chatapp.service.ChatMessageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ChatMessageController {
  private final SimpMessagingTemplate messagingTemplate;
  private final ChatMessageService chatMessageService;

  @MessageMapping("/chat")
  public void sendMessage(@Payload ChatMessage chatMessage){
    ChatMessage savedMsg = chatMessageService.send(chatMessage.getContent(),chatMessage.getChatDirection().getSender().getId(),chatMessage.getChatDirection().getRecipient().getId());
    messagingTemplate.convertAndSendToUser(savedMsg.getChatDirection().getRecipient().getUsername(),"/queue/messages",
        ChatNotification.builder().content(savedMsg.getContent()).senderId(savedMsg.getChatDirection().getSender().getId()).recipientId(
            savedMsg.getChatDirection().getRecipient().getId()).build());
  }

  @GetMapping("/messages/{senderId}/{recipientId}")
  public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable Long senderId,
      @PathVariable Long recipientId) {
    log.info("SenderId: " + senderId + " RecipientId: " + recipientId);
    return ResponseEntity
        .ok(chatMessageService.findChatMessages(senderId, recipientId));
  }
}
