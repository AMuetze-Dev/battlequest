package de.amit.battlequest.user.controller.lobby;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.amit.battlequest.user.model.Lobby;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.service.lobby.LobbyService;
import de.amit.battlequest.user.service.lobbyusers.PointService;
import de.amit.battlequest.user.service.user.UserService;

@RestController
@RequestMapping("/lobby/{code}/player/{uuid}/points")
public class PointController {

	PointService	pointService;
	LobbyService	lobbyService;
	UserService		userService;

	@PutMapping("/decrease")
	public ResponseEntity<String> decrease(@PathVariable String code, @PathVariable UUID uuid) {
		return pointService.decrease(getLobby(code), getUser(uuid));
	}

	@PutMapping("/decrease={delta}")
	public ResponseEntity<String> decreaseDelta(@PathVariable String code, @PathVariable UUID uuid, @PathVariable int delta) {
		return pointService.decrease(getLobby(code), getUser(uuid), delta);
	}

	private Lobby getLobby(String code) {
		return lobbyService.read(code);
	}

	private User getUser(UUID uuid) {
		return userService.read(uuid);
	}

	@PutMapping("/increase")
	public ResponseEntity<String> increase(@PathVariable String code, @PathVariable UUID uuid) {
		return pointService.increase(getLobby(code), getUser(uuid));
	}

	@PutMapping("/increase={delta}")
	public ResponseEntity<String> increaseDelta(@PathVariable String code, @PathVariable UUID uuid, @PathVariable int delta) {
		return pointService.increase(getLobby(code), getUser(uuid), delta);
	}

	@GetMapping
	public int read(@PathVariable String code, @PathVariable UUID uuid) {
		return pointService.read(getLobby(code), getUser(uuid));
	}

	@PutMapping("/reset")
	public ResponseEntity<String> reset(@PathVariable String code, @PathVariable UUID uuid) {
		return pointService.reset(getLobby(code), getUser(uuid));
	}

	@PutMapping("/set={value}")
	public ResponseEntity<String> set(@PathVariable String code, @PathVariable UUID uuid, @PathVariable int value) {
		return pointService.set(getLobby(code), getUser(uuid), value);
	}
}