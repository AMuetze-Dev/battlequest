package de.amit.battlequest.user.service.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.amit.battlequest.user.exception.UserNotFoundException;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.repository.UserRepository;

@Service
public class NicknameService {

	@Autowired
	UserService		userService;
	@Autowired
	UserRepository	userRepository;

	public String read(UUID uuid) {
		return userService.read(uuid).getNickname();
	}

	public ResponseEntity<String> update(User user, String nickname) {
		if (user == null || userRepository.findById(user.getUuid()).orElse(null) == null) return new UserNotFoundException().getResponseEntity();
		if (nickname == null || nickname == "") return new ResponseEntity<>("Nutzername darf nicht leer sein", HttpStatus.BAD_REQUEST);
		user.setNickname(nickname);
		userRepository.save(user);
		return new ResponseEntity<>("Nutzername wurde geändert", HttpStatus.OK);
	}

}