package com.richard.chatapp.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotification {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "chat_notification_id")
  private Long id;
  @ManyToOne
  @JoinColumn(name = "sender_id",referencedColumnName = "id")
  private Long senderId;
  @ManyToOne
  @JoinColumn(name = "recipient_id",referencedColumnName = "id")
  private Long recipientId;
  private String content;
}
