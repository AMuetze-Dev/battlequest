package de.amit.battlequest.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import de.amit.battlequest.chat.model.Message;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://aaronmuetze.ddns.net:3000")
public class ChatController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@MessageMapping("/public-message")
	@SendTo("/chatroom/public")
	public Message receivePublicMessage(@Payload Message message) {
		return message;
	}

	@MessageMapping("/team-message")
	public Message receiveTeamMessage(@Payload Message message) {
		simpMessagingTemplate.convertAndSendToUser(message.getReceiverTeamId(), null, message);
		return message;
	}
}
