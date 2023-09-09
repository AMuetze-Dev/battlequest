package de.amit.user.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.amit.user.exception.HttpException;
import de.amit.user.exception.UserNotFoundException;
import de.amit.user.exception.UserNotValidatedException;
import de.amit.user.model.Credentials;
import de.amit.user.model.User;
import de.amit.user.repository.UserRepository;

@Service
public class PasswordService {

	UserService		userService;
	@Autowired
	UserRepository	userRepository;

	public ResponseEntity<String> update(User user, String password) {
		try {
			if (validate(new Credentials(user.getUsername(), user.getPassword(), "")).getStatusCode() == HttpStatus.OK) {
				user.setPassword(password);
				userRepository.save(user);
				return new ResponseEntity<>("Password wurde geändert", HttpStatus.OK);
			}
			throw new UserNotValidatedException();
		} catch (final HttpException e) {
			return e.getResponseEntity();
		}
	}

	public ResponseEntity<String> validate(Credentials credentials) {
		final User user = userService.read(credentials.getUsername());
		if (user == null)
			throw new UserNotFoundException();
		if (!credentials.getPassword().equals(user.getPassword()))
			throw new UserNotValidatedException();
		return new ResponseEntity<>("Validierung erfolgreich", HttpStatus.OK);
	}
}
