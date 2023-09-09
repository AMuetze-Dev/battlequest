package exception;

import org.springframework.http.HttpStatus;

public class NotImplementedException extends HttpException {

	private static final long serialVersionUID = -8650830134636047866L;

	public NotImplementedException() {
		super("Diese Funktion wurde nicht hinzugefügt", HttpStatus.NOT_IMPLEMENTED);
	}

}
