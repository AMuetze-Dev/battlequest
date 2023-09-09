package de.amit.battlequest.user.controller.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.service.user.NicknameService;
import de.amit.battlequest.user.service.user.UserService;

@RestController
@RequestMapping("/player/{uuid}/nickname")
public class NicknameController {

	@Autowired
	private UserService		userService;

	@Autowired
	private NicknameService	nicknameService;

	@GetMapping
	public String read(@PathVariable UUID uuid) {
		return nicknameService.read(uuid);
	}

	@PutMapping
	public ResponseEntity<String> update(@PathVariable UUID uuid, @RequestBody String nickname) {
		final User user = userService.read(uuid);
		return nicknameService.update(user, nickname);
	}
}