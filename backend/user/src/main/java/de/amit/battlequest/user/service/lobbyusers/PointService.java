package de.amit.battlequest.user.service.lobbyusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.amit.battlequest.user.exception.HttpException;
import de.amit.battlequest.user.exception.LobbyNotFoundException;
import de.amit.battlequest.user.exception.UserNotFoundException;
import de.amit.battlequest.user.model.Lobby;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.model.LobbyUsers;
import de.amit.battlequest.user.repository.LobbyUsersRepository;

@Service
public class PointService {

	@Autowired
	LobbyUsersRepository userLobbyRepository;

	public ResponseEntity<String> decrease(Lobby lobby, User user) {
		return set(lobby, user, getUserLobby(lobby, user).getPoints() - 1);
	}

	public ResponseEntity<String> decrease(Lobby lobby, User user, int delta) {
		return set(lobby, user, getUserLobby(lobby, user).getPoints() - delta);
	}

	private LobbyUsers getUserLobby(Lobby lobby, User user) {
		return userLobbyRepository.findByUserAndLobby(user, lobby);
	}

	public ResponseEntity<String> increase(Lobby lobby, User user) {
		return set(lobby, user, getUserLobby(lobby, user).getPoints() + 1);
	}

	public ResponseEntity<String> increase(Lobby lobby, User user, int delta) {
		return set(lobby, user, getUserLobby(lobby, user).getPoints() + delta);

	}

	public int read(Lobby lobby, User user) {
		return getUserLobby(lobby, user).getPoints();
	}

	public ResponseEntity<String> reset(Lobby lobby, User user) {
		return set(lobby, user, 0);
	}

	public ResponseEntity<String> set(Lobby lobby, User user, int value) {
		testLobbyAndUser(lobby, user);
		final LobbyUsers userLobby = getUserLobby(lobby, user);
		if (value < 0) value = 0;
		if (value == userLobby.getPoints()) return new ResponseEntity<>("Punkte wurden nicht verändert", HttpStatus.NOT_MODIFIED);
		userLobby.setPoints(value);
		userLobbyRepository.save(userLobby);
		return new ResponseEntity<>("Punkte wurden verändert", HttpStatus.OK);
	}

	private void testLobbyAndUser(Lobby lobby, User user) {
		if (lobby == null) throw new LobbyNotFoundException();
		if (user == null) throw new UserNotFoundException();
		if (getUserLobby(lobby, user) == null) throw new HttpException("Spieler gehört nicht der Lobby an", HttpStatus.BAD_REQUEST);
	}
}