package com.ics.fastmial.modules.Chat.Dto;

public class SendMessageRequest {
    public String receiverUsername;
    public String message;

    public SendMessageRequest() {
    }

    public SendMessageRequest(String receiverUsername, String message) {
        this.receiverUsername = receiverUsername;
        this.message = message;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SendMessageRequest{" +
                "receiverUsername='" + receiverUsername + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
