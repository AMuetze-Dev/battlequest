package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Lobby {

	@Id
	@Column(length = 8)
	private String code;
	@ManyToOne
	@JoinColumn(name = "moderator_id")
	private User moderator;

	@OneToMany(mappedBy = "session")
	private List<User> users = new ArrayList<>();

}
