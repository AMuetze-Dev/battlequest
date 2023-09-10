package de.amit.battlequest.user.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Lobby {

	@Id
	private String		code;

	@ManyToOne
	@JoinColumn(name = "moderator_id")
	private User		moderator;

	@ManyToMany
	@JoinTable(name = "lobbies_users", joinColumns = @JoinColumn(name = "lobby_code"), inverseJoinColumns = @JoinColumn(name = "user_uuid"))
	private List<User>	users	= new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "lobbies_users", joinColumns = @JoinColumn(name = "lobby_code"), inverseJoinColumns = @JoinColumn(name = "team_uuid"))
	private List<Team>	teams	= new ArrayList<>();

	public Lobby() {
		code = UUID.randomUUID().toString().toUpperCase().substring(0, 8);
	}
}