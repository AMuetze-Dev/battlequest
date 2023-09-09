package de.amit.battlequest.user.controller.user;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.amit.battlequest.user.model.Credentials;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.service.user.UserService;

@RestController
@RequestMapping("/player")
public class UserController {

	UserService userService;

	@PostMapping
	public ResponseEntity<String> create(@RequestBody Credentials credentials) {
		return userService.create(credentials.getUsername(), credentials.getPassword());
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<String> delete(@PathVariable UUID uuid) {
		return userService.delete(userService.read(uuid));
	}

	@GetMapping("/{uuid}")
	public User read(@PathVariable UUID uuid) {
		return userService.read(uuid);
	}
}