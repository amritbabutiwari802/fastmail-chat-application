package com.ics.fastmial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String senderUsername;
	public String receiverUsername;
	public String message;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int id, String senderUsername, String receiverUsername, String message) {
		super();
		this.id = id;
		this.senderUsername = senderUsername;
		this.receiverUsername = receiverUsername;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSenderUsername() {
		return senderUsername;
	}
	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
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
		return "Message [id=" + id + ", senderUsername=" + senderUsername + ", receiverUsername=" + receiverUsername
				+ ", message=" + message + "]";
	}
	
	

}
