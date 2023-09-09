package de.amit.user.controller.user;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.amit.user.exception.UserNotFoundException;
import de.amit.user.model.Credentials;
import de.amit.user.model.User;
import de.amit.user.service.user.PasswordService;
import de.amit.user.service.user.UserService;

@RestController
public class PasswordController {

	UserService		userService;
	PasswordService	passwordService;

	@PutMapping("/player/{uuid}/password")
	public ResponseEntity<String> update(@PathVariable UUID uuid, @RequestBody Credentials credentials) {
		final User user = userService.read(uuid);
		if (user.getUsername().equals(credentials.getUsername()))
			return passwordService.update(user, credentials.getPassword());
		return new UserNotFoundException().getResponseEntity();
	}

	@GetMapping("/player/password/validate")
	public ResponseEntity<String> validate(@RequestBody Credentials credentials) {
		return passwordService.validate(credentials);
	}
}
