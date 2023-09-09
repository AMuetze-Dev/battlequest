package de.amit.user.service.lobby;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import de.amit.user.UserApplication;
import de.amit.user.exception.LobbyNotFoundException;
import de.amit.user.model.Lobby;
import de.amit.user.model.User;
import de.amit.user.repository.LobbyRepository;

@SpringBootTest(classes = UserApplication.class)
public class LobbyServiceTest {

	private LobbyService	lobbyService;

	@Autowired
	private LobbyRepository	lobbyRepository;

	void assertResponseEntity(ResponseEntity<String> response, HttpStatus status, String message) {
		assertEquals(status, response.getStatusCode());
		assertEquals(message, response.getBody());
	}

	@BeforeEach
	void setup() {
		lobbyRepository = mock(LobbyRepository.class);
		lobbyService = new LobbyService();
		lobbyService.lobbyRepository = lobbyRepository;
	}

	@Test
	void testCreate() {
		when(lobbyRepository.findById(anyString())).thenReturn(null);
		assertResponseEntity(lobbyService.create(), HttpStatus.CREATED, "Lobby wurde angelegt");
	}

	@Test
	void testDelete() {
		final Lobby lobby = new Lobby();
		assertResponseEntity(lobbyService.delete(lobby), HttpStatus.OK, "Lobby wurde entfernt");
		verify(lobbyRepository, times(1)).delete(lobby);
		assertResponseEntity(lobbyService.delete(null), HttpStatus.NOT_FOUND, "Lobby wurde nicht gefunden");
	}

	@Test
	void testDeleteUser() {
		final Lobby lobby = new Lobby();
		final User user = new User();
		user.setLobby(lobby);
		assertResponseEntity(lobbyService.deleteUser(lobby, user), HttpStatus.OK, "Spieler wurde entfernt");
		verify(lobbyRepository, times(1)).save(lobby);

		assertResponseEntity(lobbyService.deleteUser(null, user), HttpStatus.NOT_FOUND, "Lobby wurde nicht gefunden");
		assertResponseEntity(lobbyService.deleteUser(lobby, null), HttpStatus.NOT_FOUND, "Spieler wurde nicht gefunden");
		user.setLobby(new Lobby());
		assertResponseEntity(lobbyService.deleteUser(lobby, user), HttpStatus.BAD_REQUEST, "Spieler gehört nicht der Lobby an");
	}

	@Test
	void testRead() {
		final Lobby lobby = new Lobby();
		when(lobbyRepository.findById(anyString())).thenReturn(Optional.of(lobby));
		final Lobby result = lobbyService.read("testCode");
		assertEquals(lobby, result);
		when(lobbyRepository.findById(anyString())).thenReturn(Optional.empty());
		assertThrows(LobbyNotFoundException.class, () -> lobbyService.read("testCode"));
	}

	@Test
	void testReadAll() {
		final List<Lobby> lobbyList = new ArrayList<>();
		when(lobbyRepository.findAll()).thenReturn(lobbyList);
		final List<Lobby> result = lobbyService.readAll();
		assertEquals(lobbyList, result);
	}

	@Test
	void testUpdate() {
		assertResponseEntity(lobbyService.update(), HttpStatus.NOT_IMPLEMENTED, "Diese Funktion wurde nicht implementiert");
	}
}
