package de.amit.battlequest.user.service.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.amit.battlequest.user.exception.NotImplementedException;
import de.amit.battlequest.user.exception.UserNotFoundException;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public ResponseEntity<String> create(String username, String password) {
		if (username == null || username.equals("")) return new ResponseEntity<>("Username darf nicht leer sein", HttpStatus.BAD_REQUEST);
		if (username.length() > 32) return new ResponseEntity<>("Username darf maximal 32 Zeichen haben", HttpStatus.BAD_REQUEST);
		if (password == null || password.equals("")) return new ResponseEntity<>("Passwort darf nicht leer sein", HttpStatus.BAD_REQUEST);
		if (password.length() > 32) return new ResponseEntity<>("Passwort darf maximal 32 Zeichen haben", HttpStatus.BAD_REQUEST);
		if (password.length() < 8) return new ResponseEntity<>("Passwort muss mindestens als 8 Zeichen haben", HttpStatus.BAD_REQUEST);
		userRepository.save(new User(username, password));
		return new ResponseEntity<>("Spieler wurde angelegt", HttpStatus.CREATED);
	}

	public ResponseEntity<String> delete(User user) {
		if (user == null) return new UserNotFoundException().getResponseEntity();
		userRepository.delete(user);
		return new ResponseEntity<>("Spieler wurde entfernt", HttpStatus.OK);
	}

	public User read(String username) {
		return userRepository.findByUsername(username);
	}

	public User read(UUID uuid) {
		return userRepository.findById(uuid).orElseThrow(UserNotFoundException::new);
	}

	public ResponseEntity<String> update() {
		return new NotImplementedException().getResponseEntity();
	}
}