package de.amit.battlequest.user.controller.lobbyusers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.amit.battlequest.user.model.Lobby;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.service.lobby.LobbyService;
import de.amit.battlequest.user.service.user.UserService;

@RestController
@RequestMapping("/lobby/{code}/player")
public class LobbyUsersController {

	@Autowired
	private LobbyService	lobbyService;

	@Autowired
	private UserService		userService;

	@PostMapping("/{uuid}")
	public ResponseEntity<String> create(@PathVariable String code, @PathVariable UUID uuid) {
		final Lobby lobby = lobbyService.read(code);
		final User user = userService.read(uuid);
		return lobbyService.createUser(lobby, user);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<String> delete(@PathVariable String code, @PathVariable UUID uuid) {
		final Lobby lobby = lobbyService.read(code);
		final User user = userService.read(uuid);
		return lobbyService.deleteUser(lobby, user);
	}

	@GetMapping("/all")
	public List<User> readAll(@PathVariable String code) {
		final Lobby lobby = lobbyService.read(code);
		return lobbyService.readAllUser(lobby);
	}

}
