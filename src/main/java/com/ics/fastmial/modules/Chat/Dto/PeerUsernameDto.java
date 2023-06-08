package com.ics.fastmial.modules.Chat.Dto;

public class PeerUsernameDto {
    public String username;

    public PeerUsernameDto() {
    }

    public PeerUsernameDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PeerUsernameDto{" +
                "username='" + username + '\'' +
                '}';
    }
}
