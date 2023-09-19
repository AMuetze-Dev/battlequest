package de.amit.battlequest.user.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class UserNotFoundException extends HttpException {

	@Serial
	private static final long serialVersionUID = 1;

	public UserNotFoundException() {
		super("Spieler wurde nicht gefunden", HttpStatus.NOT_FOUND);
	}

}