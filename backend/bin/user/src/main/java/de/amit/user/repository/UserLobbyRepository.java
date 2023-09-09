package de.amit.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.amit.user.model.Lobby;
import de.amit.user.model.User;
import de.amit.user.model.UserLobby;

public interface UserLobbyRepository extends JpaRepository<UserLobby, Long> {

	UserLobby findByUserAndLobby(User user, Lobby lobby);
}
