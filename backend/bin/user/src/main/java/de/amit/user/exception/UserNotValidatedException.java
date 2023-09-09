package de.amit.user.exception;

import org.springframework.http.HttpStatus;

public class UserNotValidatedException extends HttpException {

	private static final long serialVersionUID = -1440650129782699650L;

	public UserNotValidatedException() {
		super("Validierung fehlgeschlagen", HttpStatus.NOT_FOUND);
	}
}
