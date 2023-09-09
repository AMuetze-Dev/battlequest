package de.amit.user.controller.lobby;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.amit.user.model.Lobby;
import de.amit.user.service.lobby.LobbyService;

@RestController
@RequestMapping("/lobby")
public class LobbyController {

	@Autowired
	private LobbyService lobbyService;

	@PostMapping
	public ResponseEntity<String> create() {
		return lobbyService.create();
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<String> delete(@PathVariable String code) {
		final Lobby lobby = read(code);
		return lobbyService.delete(lobby);
	}

	@GetMapping("/{code}")
	public Lobby read(@PathVariable String code) {
		return lobbyService.read(code);
	}

	@GetMapping
	public List<Lobby> readAll() {
		return lobbyService.readAll();
	}

}
