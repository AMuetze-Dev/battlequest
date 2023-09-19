package de.amit.battlequest.chat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {

	enum Status {
		JOIN, MESSAGE, LEAVE;
	}

	private String	senderName;
	private String	receiverTeamId;
	private String	message;
	private Status	status;
}
