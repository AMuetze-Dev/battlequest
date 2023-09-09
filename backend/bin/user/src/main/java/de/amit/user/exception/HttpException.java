package de.amit.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class HttpException extends RuntimeException {

	private static final long serialVersionUID = 8403690835422617844L;
	private final HttpStatus httpStatus;

	public HttpException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public ResponseEntity<String> getResponseEntity() {
		return new ResponseEntity<>(getMessage(), httpStatus);
	}
}
