package controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import service.lobby.LobbyService;
import service.lobby.ModeratorService;

@RestController
@RequestMapping("/lobby/{code}/master")
public class ModeratorController {

	@Autowired
	private ModeratorService moderatorService;

	@Autowired
	private LobbyService lobbyService;

	@DeleteMapping
	public ResponseEntity<String> delete(@PathVariable String code) {
		return moderatorService.delete(lobbyService.read(code));
	}

	@GetMapping
	public User read(@PathVariable String code) {
		return moderatorService.read(lobbyService.read(code));
	}

	@PutMapping
	public ResponseEntity<String> update(@PathVariable String code, @RequestBody UUID moderatorUuid) {
		final User user = new User();
		// TODO UserService einbinden
		return moderatorService.update(lobbyService.read(code), user);
	}
}
