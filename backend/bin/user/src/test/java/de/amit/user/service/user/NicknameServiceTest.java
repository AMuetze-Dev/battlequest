package de.amit.user.service.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import de.amit.user.UserApplication;
import de.amit.user.model.User;
import de.amit.user.repository.UserRepository;

@SpringBootTest(classes = UserApplication.class)
public class NicknameServiceTest {

	private NicknameService	nicknameService;
	private UserRepository	userRepository;
	private UserService		userService;

	void assertResponseEntity(ResponseEntity<String> response, HttpStatus status, String message) {
		assertEquals(status, response.getStatusCode());
		assertEquals(message, response.getBody());
	}

	@BeforeEach
	void setup() {
		userRepository = mock(UserRepository.class);
		userService = mock(UserService.class);
		nicknameService = new NicknameService();
		nicknameService.userRepository = userRepository;
		nicknameService.userService = userService;
	}

	@Test
	void testRead() {
		final User user = new User("testUser", "test1234");
		when(userService.read(user.getUuid())).thenReturn(user);
		final String nickname = nicknameService.read(user.getUuid());
		assertEquals(user.getNickname(), nickname);
	}

	@Test
	void testUpdate() {
		final User user = new User("testUser", "test1234");
		when(userRepository.findById(user.getUuid())).thenReturn(Optional.of(user));
		assertResponseEntity(nicknameService.update(null, "WhateverFloatsYourBoat"), HttpStatus.NOT_FOUND, "Spieler wurde nicht gefunden");

		assertResponseEntity(nicknameService.update(user, null), HttpStatus.BAD_REQUEST, "Nutzername darf nicht leer sein");
		assertResponseEntity(nicknameService.update(user, ""), HttpStatus.BAD_REQUEST, "Nutzername darf nicht leer sein");

		assertResponseEntity(nicknameService.update(user, "WhateverFloatsYourBoat"), HttpStatus.OK, "Nutzername wurde geändert");
	}
}
