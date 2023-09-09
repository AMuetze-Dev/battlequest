package de.amit.battlequest.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserLobby {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long	id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User	user;

	@ManyToOne
	@JoinColumn(name = "lobby_code")
	private Lobby	lobby;

	private int		points;

	public UserLobby(User user, Lobby lobby) {
		this.user = user;
		this.lobby = lobby;
		points = 0;
	}
}