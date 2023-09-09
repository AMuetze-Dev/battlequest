package de.amit.battlequestOLD.controller.rest.login;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.amit.battlequestOLD.controller.rest.player.PasswordRessource;
import de.amit.battlequestOLD.controller.rest.player.PlayerRessource;
import de.amit.battlequestOLD.model.Credentials;
import de.amit.battlequestOLD.model.Player;

@RestController
@RequestMapping("/login")
public class LoginRessource {

	@Autowired
	private PlayerRessource playerRessource;

	@Autowired
	private PasswordRessource passwordRessource;

	@PostMapping
	public UUID login(@RequestBody Credentials credentials) {
		final Player player = playerRessource.read(credentials.getUsername());
		if (player != null && passwordRessource.validate(credentials))
			return player.getUuid();
		return null;
	}

}
