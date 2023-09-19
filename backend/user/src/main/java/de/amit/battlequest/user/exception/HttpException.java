package de.amit.battlequest.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

import java.io.Serial;

@Getter
public class HttpException extends RuntimeException {

	@Serial
	private static final long	serialVersionUID	= 1;
	private final HttpStatus	httpStatus;

	public HttpException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public ResponseEntity<String> getResponseEntity() { return new ResponseEntity<>(getMessage(), httpStatus); }
}