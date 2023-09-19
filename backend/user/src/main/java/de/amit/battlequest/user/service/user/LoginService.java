package de.amit.battlequest.user.service.user;

import java.util.UUID;

import de.amit.battlequest.user.exception.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import de.amit.battlequest.user.exception.UserNotFoundException;
import de.amit.battlequest.user.exception.UserNotValidatedException;
import de.amit.battlequest.user.model.Credentials;
import de.amit.battlequest.user.model.User;

@Service
public class LoginService {

	@Autowired
	UserService		userService;
	@Autowired
	PasswordService	passwordService;

	public UUID login(Credentials credentials) {
		try {
			final User user = userService.read(credentials.getUsername());
			if (user == null) throw new UserNotFoundException();
			if (passwordService.validate(credentials).getStatusCode() != HttpStatus.OK) throw new UserNotValidatedException();
			return user.getUuid();
		} catch(HttpException e) {
			return null;
		}
	}


}
