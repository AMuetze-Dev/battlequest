package de.amit.battlequest.user.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class ModeratorNotFoundException extends HttpException {

	@Serial
	private static final long serialVersionUID = 1;

	public ModeratorNotFoundException() {
		super("Moderator wurde nicht gefunden", HttpStatus.NOT_FOUND);
	}
}