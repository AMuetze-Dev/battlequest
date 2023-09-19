package de.amit.battlequest.user.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class LobbyNotFoundException extends HttpException {

	@Serial
	private static final long serialVersionUID = 1;

	public LobbyNotFoundException() {
		super("Lobby wurde nicht gefunden", HttpStatus.NOT_FOUND);
	}
}