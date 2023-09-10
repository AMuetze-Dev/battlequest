package de.amit.battlequest.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.amit.battlequest.user.model.Lobby;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.model.LobbyUsers;

public interface LobbyUsersRepository extends JpaRepository<LobbyUsers, Long> {

	LobbyUsers findByUserAndLobby(User user, Lobby lobby);
}