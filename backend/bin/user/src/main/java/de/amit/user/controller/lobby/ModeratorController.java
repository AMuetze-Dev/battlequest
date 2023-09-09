package de.amit.user.controller.lobby;

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

import de.amit.user.model.User;
import de.amit.user.service.lobby.LobbyService;
import de.amit.user.service.lobby.ModeratorService;
import de.amit.user.service.user.UserService;

@RestController
@RequestMapping("/lobby/{code}/master")
public class ModeratorController {

	@Autowired
	private ModeratorService	moderatorService;
	@Autowired
	private LobbyService		lobbyService;
	@Autowired
	private UserService			userService;

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
		final User user = userService.read(moderatorUuid);
		return moderatorService.update(lobbyService.read(code), user);
	}
}
