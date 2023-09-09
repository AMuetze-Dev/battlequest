package de.amit.battlequest.user.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Lobby {

	@Id
	@Column(length = 8)
	private String		code;
	@ManyToOne
	@JoinColumn(name = "moderator_id")
	private User		moderator;

	@OneToMany
	@JoinColumns({ @JoinColumn(name = "lobby_code", referencedColumnName = "code"), @JoinColumn(name = "moderator_id", referencedColumnName = "moderator_id") })
	private List<User>	users	= new ArrayList<>();

	public Lobby() {
		code = UUID.randomUUID().toString().toUpperCase().substring(0, 8);
	}
}