package de.amit.user.service.lobby;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.amit.user.exception.HttpException;
import de.amit.user.exception.LobbyNotFoundException;
import de.amit.user.exception.NotImplementedException;
import de.amit.user.exception.UserNotFoundException;
import de.amit.user.model.Lobby;
import de.amit.user.model.User;
import de.amit.user.repository.LobbyRepository;

@Service
public class LobbyService {

	@Autowired
	LobbyRepository lobbyRepository;

	public ResponseEntity<String> create() {
		final Lobby lobby = new Lobby();
		while (lobbyRepository.findById(lobby.getCode()) != null)
			lobby.setCode(generateCode());
		lobbyRepository.save(lobby);
		return new ResponseEntity<>("Lobby wurde angelegt", HttpStatus.CREATED);
	}

	public ResponseEntity<String> delete(Lobby lobby) {
		try {
			if (lobby == null)
				return new LobbyNotFoundException().getResponseEntity();
			lobbyRepository.delete(lobby);
			return new ResponseEntity<>("Lobby wurde entfernt", HttpStatus.OK);
		} catch (final HttpException e) {
			return e.getResponseEntity();
		}
	}

	public ResponseEntity<String> deleteUser(Lobby lobby, User user) {
		try {
			if (lobby == null)
				return new LobbyNotFoundException().getResponseEntity();
			if (user == null)
				return new UserNotFoundException().getResponseEntity();
			if (!lobby.getCode().equals(user.getLobby().getCode()))
				return new ResponseEntity<>("Spieler gehört nicht der Lobby an", HttpStatus.BAD_REQUEST);
			lobby.getUsers().remove(user);
			lobbyRepository.save(lobby);
			return new ResponseEntity<>("Spieler wurde entfernt", HttpStatus.OK);
		} catch (final HttpException e) {
			return e.getResponseEntity();
		}
	}

	private String generateCode() {
		return UUID.randomUUID().toString().toUpperCase().substring(0, 8);
	}

	public Lobby read(String code) {
		return lobbyRepository.findById(code).orElseThrow(LobbyNotFoundException::new);
	}

	public List<Lobby> readAll() {
		return lobbyRepository.findAll();
	}

	public ResponseEntity<String> update() {
		return new NotImplementedException().getResponseEntity();
	}

}
