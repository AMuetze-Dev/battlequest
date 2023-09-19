package de.amit.battlequest.user.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class UserNotValidatedException extends HttpException {

	@Serial
	private static final long serialVersionUID = 1;

	public UserNotValidatedException() {
		super("Validierung fehlgeschlagen", HttpStatus.NOT_FOUND);
	}
}