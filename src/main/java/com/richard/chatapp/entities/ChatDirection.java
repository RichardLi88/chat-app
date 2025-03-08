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
public class ChatDirection {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "chatroom_id_seq")
  private Long id;
  @ManyToOne
  @JoinColumn(name = "chat_room_id",referencedColumnName = "id")
  private ChatRoom chatRoom;
  @ManyToOne
  @JoinColumn(name = "sender_id",referencedColumnName = "id")
  private User sender;
  @ManyToOne
  @JoinColumn(name = "recipient_id",referencedColumnName = "id")
  private User recipient;
}
