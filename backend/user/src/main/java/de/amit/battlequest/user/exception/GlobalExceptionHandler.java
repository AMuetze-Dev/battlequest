package de.amit.battlequest.user.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HttpException.class)
	public ResponseEntity<String> handleHttpException(HttpException e) {
		return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
	}
}
