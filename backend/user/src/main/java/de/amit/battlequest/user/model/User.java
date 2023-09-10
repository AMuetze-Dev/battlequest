package de.amit.battlequest.user.model;

import java.util.Random;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID	uuid	= UUID.randomUUID();
	@Column(length = 32)
	private String	username;
	@Column(length = 32)
	private String	nickname;
	@Column(length = 32)
	private String	password;

	@Transient
	@ManyToOne
	@JoinColumn(name = "lobby_code")
	private Lobby	lobby;

	@Transient
	@ManyToOne
	@JoinColumn(name = "team_uuid")
	private Team	team;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		nickname = "DummyUser" + new Random().nextInt(10000, 99999);
	}

	@JsonIgnore
	public Lobby getLobby() { return lobby; }

	@JsonIgnore
	public String getPassword() { return password; }

	@JsonIgnore
	public Team getTeam() { return team; }

	@JsonIgnore
	public String getUsername() { return username; }
}