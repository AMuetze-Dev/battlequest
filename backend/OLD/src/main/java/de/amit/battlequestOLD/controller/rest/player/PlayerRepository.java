package de.amit.battlequestOLD.controller.rest.player;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.amit.battlequestOLD.model.Player;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
	public Player findByUsername(String username);
}
