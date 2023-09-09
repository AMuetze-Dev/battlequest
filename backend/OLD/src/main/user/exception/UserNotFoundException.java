package exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends HttpException {

	private static final long serialVersionUID = 3116661302116450142L;

	public UserNotFoundException() {
		super("Spielleiter wurde nicht gefunden", HttpStatus.NOT_FOUND);
	}

}
