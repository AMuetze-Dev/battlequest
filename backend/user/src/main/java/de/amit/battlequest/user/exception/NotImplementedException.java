package de.amit.battlequest.user.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class NotImplementedException extends HttpException {

	@Serial
	private static final long serialVersionUID = 1;

	public NotImplementedException() {
		super("Diese Funktion wurde nicht implementiert", HttpStatus.NOT_IMPLEMENTED);
	}

}