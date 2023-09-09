package service.player;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import exception.HttpException;
import exception.NotImplementedException;
import exception.UserNotFoundException;
import model.User;
import repository.UserRepository;

public class PlayerService {

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<String> create(String username, String password) {
		if (username == null || username.equals(""))
			return new ResponseEntity<>("Username darf nicht leer sein", HttpStatus.BAD_REQUEST);
		if (password == null || password.equals(""))
			return new ResponseEntity<>("Passwort darf nicht leer sein", HttpStatus.BAD_REQUEST);
		if (password.length() < 8)
			return new ResponseEntity<>("Passwort muss mehr als 8 Zeichen haben", HttpStatus.BAD_REQUEST);
		userRepository.save(new User(username, password));
		return new ResponseEntity<>("Spieler wurde angelegt", HttpStatus.OK);
	}

	public ResponseEntity<String> delete(User user) {
		try {
			if (user == null)
				throw new UserNotFoundException();
			userRepository.delete(user);
			return new ResponseEntity<>("Spieler wurde entfernt", HttpStatus.OK);
		} catch (final HttpException e) {
			return e.getResponseEntity();
		}
	}

	public User read(UUID uuid) {
		return userRepository.findById(uuid).orElseThrow(UserNotFoundException::new);
	}

	public ResponseEntity<String> update() {
		return new NotImplementedException().getResponseEntity();
	}
}
