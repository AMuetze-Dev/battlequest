package de.amit.user.exception;

import org.springframework.http.HttpStatus;

public class LobbyNotFoundException extends HttpException {

	private static final long serialVersionUID = -2412966536956365109L;

	public LobbyNotFoundException() {
		super("Lobby wurde nicht gefunden", HttpStatus.NOT_FOUND);
	}
}
