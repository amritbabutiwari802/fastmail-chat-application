package com.ics.fastmial.modules.Chat;

import com.ics.fastmial.modules.Chat.Dto.PeerUsernameDto;
import com.ics.fastmial.modules.Chat.Dto.SendMessageRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    ChatService chatService;
    @PostMapping("/post-message")
    ResponseEntity<?> postMessage(HttpServletRequest httpServletRequest, @RequestBody SendMessageRequest sendMessageRequest){
        String senderUsername = httpServletRequest.getRemoteUser();
        String receiverUsername = sendMessageRequest.getReceiverUsername();
        String messageBody = sendMessageRequest.getMessage();
        return this.chatService.sendMessage(senderUsername, receiverUsername,messageBody);
    }

    @GetMapping("/load-message/by-receiver")
    public ResponseEntity<?> loadMessagebyReceiver(HttpServletRequest httpServletRequest, @RequestBody PeerUsernameDto peerUsernameDto){
        String myUsername = httpServletRequest.getRemoteUser();
        String peerUsername = peerUsernameDto.getUsername();
        return this.chatService.getAllMessageByPeerUsername(myUsername, peerUsername);
    }

    @GetMapping("/load-message/all")
    public ResponseEntity<?> loadAllMessage(HttpServletRequest httpServletRequest){
        String myUsername = httpServletRequest.getRemoteUser();
        return this.chatService.getAllMessage(myUsername);
    }

}
