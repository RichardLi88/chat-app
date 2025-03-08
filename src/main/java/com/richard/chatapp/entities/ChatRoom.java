package com.richard.chatapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "chatroom_id_seq")
  private Long id;
  private String chatRoomId;

  @ManyToOne
  @JoinColumn(name = "sender_id",referencedColumnName = "id")
  private User sender;
  @ManyToOne
  @JoinColumn(name = "recipient_id",referencedColumnName = "id")
  private User recipient;
}
