package de.amit.battlequest.user.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID		uuid	= UUID.randomUUID();

	@Column(length = 32)
	private String		teamname;

	@ManyToOne
	@JoinColumn(name = "leader_id")
	private User		leader;

	@Transient
	@ManyToOne
	@JoinColumn(name = "lobby_code")
	private Lobby		lobby;

	@ManyToMany
	@JoinTable(name = "lobbies_users", joinColumns = @JoinColumn(name = "team_uuid"), inverseJoinColumns = @JoinColumn(name = "user_uuid"))
	private List<User>	users	= new ArrayList<>();

	public void addUser(User user) {
		if (user.getLobby().getCode().equals(lobby.getCode())) users.add(user);
	}
}
