package com.richard.chatapp.service;

import com.richard.chatapp.repository.ChatRoomRepository;
import com.richard.chatapp.room.ChatRoom;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
  private final ChatRoomRepository chatRoomRepository;

  public Optional<String> getChatRoomId(Long senderId, Long recipientId, boolean createNewRoom){
    return chatRoomRepository.findBySenderRecipientID(senderId,recipientId)
        .map(ChatRoom::getChatRoomId)
        .or(()->{
      if (createNewRoom) {
        String chatId = createNewChatRoom(senderId,recipientId);
        return Optional.of(chatId);
      }
      return Optional.empty();
    });
  }

  private String createNewChatRoom(Long senderId, Long recipientId) {
    String chatId = String.format("%d_$_%d",senderId,recipientId);

    //building chat rooms so that both sender and recipient can send and receive messages in the chatroom
    ChatRoom senderChatRoom = ChatRoom.builder().chatRoomId(chatId).senderId(senderId).recipientId(recipientId)
        .build();
    ChatRoom recipientChatRoom = ChatRoom.builder().chatRoomId(chatId).senderId(recipientId).recipientId(senderId)
        .build();

    chatRoomRepository.save(senderChatRoom);
    chatRoomRepository.save(recipientChatRoom);

    return chatId;
  }


}
