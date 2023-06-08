package com.ics.fastmial.modules.Chat;

import com.ics.fastmial.entity.Message;
import com.ics.fastmial.repositories.MessageRepository;
import com.ics.fastmial.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> sendMessage(String senderUsername, String receiverUsername, String message){
        if(!userRepository.existsByUsername(receiverUsername)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid receiver username");
        }

        Message messageEntity = new Message();
        messageEntity.setSenderUsername(senderUsername);
        messageEntity.setReceiverUsername(receiverUsername);
        messageEntity.setMessage(message);
        messageRepository.save(messageEntity);
        return ResponseEntity.ok().body("message sent");

    }

    public ResponseEntity<?> getAllMessageByPeerUsername(String myUsername, String peerUsername){
        if(!userRepository.existsByUsername(peerUsername)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid receiver username");
        }

        List<Message> conversations = messageRepository.listAllMessageByPeerUsername(myUsername,peerUsername);
        return ResponseEntity.ok(conversations);
    }

    public ResponseEntity<?> getAllMessage(String myUsername){
        List<Message> conversations = this.messageRepository.findAllMessage(myUsername);
        return ResponseEntity.ok(conversations);
    }

}
