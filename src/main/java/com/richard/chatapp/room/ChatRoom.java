package com.richard.chatapp.room;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ChatRoom {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "chatroom_id_seq")
  private Long id;
  private String chatRoomId;
  private Long senderId;
  private Long recipientId;
}
