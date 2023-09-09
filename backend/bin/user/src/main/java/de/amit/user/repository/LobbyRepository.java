package de.amit.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.amit.user.model.Lobby;

public interface LobbyRepository extends JpaRepository<Lobby, String> {

}
