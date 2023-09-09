package de.amit.battlequest.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.amit.battlequest.user.model.Lobby;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.model.UserLobby;

public interface UserLobbyRepository extends JpaRepository<UserLobby, Long> {

	UserLobby findByUserAndLobby(User user, Lobby lobby);
}