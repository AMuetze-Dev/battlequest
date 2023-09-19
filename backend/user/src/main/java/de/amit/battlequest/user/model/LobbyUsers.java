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
@Entity(name = "lobby_users")
public class LobbyUsers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long	id;

	@ManyToOne
	@JoinColumn(name = "user_uuid")
	private User	user;

	@ManyToOne
	@JoinColumn(name = "lobby_code")
	private Lobby	lobby;

	@ManyToOne
	@JoinColumn(name = "team_uuid")
	private Team	team;

	private int		points;

	public LobbyUsers(User user, Lobby lobby) {
		this.user = user;
		this.lobby = lobby;
		points = 0;
	}
}