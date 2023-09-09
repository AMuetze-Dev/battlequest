package de.amit.battlequest.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.amit.battlequest.user.model.Lobby;

public interface LobbyRepository extends JpaRepository<Lobby, String> {

}