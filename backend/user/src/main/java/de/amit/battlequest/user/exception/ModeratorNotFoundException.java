package de.amit.battlequest.user.exception;

import org.springframework.http.HttpStatus;

public class ModeratorNotFoundException extends HttpException {

	private static final long serialVersionUID = 1610404483968918751L;

	public ModeratorNotFoundException() {
		super("Moderator wurde nicht gefunden", HttpStatus.NOT_FOUND);
	}
}