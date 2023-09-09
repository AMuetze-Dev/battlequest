package de.amit.user.service.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import de.amit.user.UserApplication;
import de.amit.user.exception.UserNotFoundException;
import de.amit.user.model.User;
import de.amit.user.repository.UserRepository;

@SpringBootTest(classes = UserApplication.class)
public class UserServiceTest {

	private UserService		userService;

	@Autowired
	private UserRepository	userRepository;

	void assertResponseEntity(ResponseEntity<String> response, HttpStatus status, String message) {
		assertEquals(status, response.getStatusCode());
		assertEquals(message, response.getBody());
	}

	@BeforeEach
	void setup() {
		userRepository = mock(UserRepository.class);
		userService = new UserService();
		userService.userRepository = userRepository;
	}

	@Test
	void testCreate() {
		assertResponseEntity(userService.create("", "test1234"), HttpStatus.BAD_REQUEST, "Username darf nicht leer sein");
		assertResponseEntity(userService.create(null, "test1234"), HttpStatus.BAD_REQUEST, "Username darf nicht leer sein");
		assertResponseEntity(userService.create("abcdefghijklmnopqrstuvwxyzabcdefg", "test1234"), HttpStatus.BAD_REQUEST, "Username darf maximal 32 Zeichen haben");

		assertResponseEntity(userService.create("testUser", ""), HttpStatus.BAD_REQUEST, "Passwort darf nicht leer sein");
		assertResponseEntity(userService.create("testUser", null), HttpStatus.BAD_REQUEST, "Passwort darf nicht leer sein");
		assertResponseEntity(userService.create("testUser", "abcdefghijklmnopqrstuvwxyzabcdefg"), HttpStatus.BAD_REQUEST, "Passwort darf maximal 32 Zeichen haben");

		assertResponseEntity(userService.create("testUser", "test123"), HttpStatus.BAD_REQUEST, "Passwort muss mindestens als 8 Zeichen haben");

		assertResponseEntity(userService.create("testUser", "test1234"), HttpStatus.CREATED, "Spieler wurde angelegt");
	}

	@Test
	void testDelete() {
		assertResponseEntity(userService.delete(null), HttpStatus.NOT_FOUND, "Spieler wurde nicht gefunden");
		final User user = new User("testUser", "test1234");
		assertResponseEntity(userService.delete(user), HttpStatus.OK, "Spieler wurde entfernt");
		verify(userRepository, times(1)).delete(user);
	}

	@Test
	void testRead() {
		final User user = new User("testUser", "test1234");
		when(userRepository.findById(user.getUuid())).thenReturn(Optional.of(user));
		final User result = userService.read(user.getUuid());
		assertEquals(user, result);
		when(userRepository.findById(user.getUuid())).thenReturn(Optional.empty());
		assertThrows(UserNotFoundException.class, () -> userService.read(user.getUuid()));
	}

	@Test
	void testUpdate() {
		assertResponseEntity(userService.update(), HttpStatus.NOT_IMPLEMENTED, "Diese Funktion wurde nicht implementiert");
	}
}
