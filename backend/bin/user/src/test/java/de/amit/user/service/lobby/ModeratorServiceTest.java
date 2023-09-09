package de.amit.user.service.lobby;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import de.amit.user.UserApplication;
import de.amit.user.exception.LobbyNotFoundException;
import de.amit.user.exception.ModeratorNotFoundException;
import de.amit.user.model.Lobby;
import de.amit.user.model.User;
import de.amit.user.repository.LobbyRepository;

@SpringBootTest(classes = UserApplication.class)
public class ModeratorServiceTest {

	private ModeratorService	moderatorService;

	@Autowired
	private LobbyRepository		lobbyRepository;

	void assertResponseEntity(ResponseEntity<String> response, HttpStatus status, String message) {
		assertEquals(status, response.getStatusCode());
		assertEquals(message, response.getBody());
	}

	@BeforeEach
	void setup() {
		lobbyRepository = mock(LobbyRepository.class);
		moderatorService = new ModeratorService();
		moderatorService.lobbyRepository = lobbyRepository;
	}

	@Test
	void testCreate() {
		final Lobby lobby = new Lobby();
		final User moderator = new User();
		moderator.setLobby(lobby);
		assertResponseEntity(moderatorService.create(lobby, moderator), HttpStatus.CREATED, "Moderator wurde gesetzt");
		verify(lobbyRepository, times(1)).save(lobby);
		assertResponseEntity(moderatorService.create(null, moderator), HttpStatus.NOT_FOUND, "Lobby wurde nicht gefunden");
		assertResponseEntity(moderatorService.create(lobby, null), HttpStatus.NOT_FOUND, "Moderator wurde nicht gefunden");
		lobby.setModerator(moderator);
		assertResponseEntity(moderatorService.create(lobby, moderator), HttpStatus.BAD_REQUEST, "Ist bereits Moderator der Lobby");
		lobby.setModerator(null);
		moderator.setLobby(new Lobby());
		assertResponseEntity(moderatorService.create(lobby, moderator), HttpStatus.BAD_REQUEST, "Moderator gehört nicht der Lobby an");
	}

	@Test
	void testDelete() {
		final Lobby lobby = new Lobby();
		final User moderator = new User();
		lobby.setModerator(moderator);
		assertResponseEntity(moderatorService.delete(lobby), HttpStatus.OK, "Moderator wurde entfernt");
		assertResponseEntity(moderatorService.delete(lobby), HttpStatus.BAD_REQUEST, "Diese Lobby hat keinen Moderator");
	}

	@Test
	void testRead() {
		final Lobby lobby = new Lobby();
		final User moderator = new User();
		lobby.setModerator(moderator);

		final User result = moderatorService.read(lobby);
		assertEquals(moderator, result);
		assertThrows(LobbyNotFoundException.class, () -> moderatorService.read(null));
		assertThrows(ModeratorNotFoundException.class, () -> moderatorService.read(new Lobby()));
	}

	@Test
	void testUpdate() {
		final Lobby lobby = new Lobby();
		final User moderator = new User();
		moderator.setLobby(lobby);
		assertResponseEntity(moderatorService.update(lobby, moderator), HttpStatus.OK, "Moderator wurde ausgetauscht");
		verify(lobbyRepository, times(1)).save(lobby);
		assertResponseEntity(moderatorService.update(null, moderator), HttpStatus.NOT_FOUND, "Lobby wurde nicht gefunden");
		assertResponseEntity(moderatorService.update(lobby, null), HttpStatus.NOT_FOUND, "Moderator wurde nicht gefunden");
		lobby.setModerator(moderator);
		assertResponseEntity(moderatorService.update(lobby, moderator), HttpStatus.BAD_REQUEST, "Ist bereits Moderator der Lobby");
		lobby.setModerator(null);
		moderator.setLobby(new Lobby());
		assertResponseEntity(moderatorService.update(lobby, moderator), HttpStatus.BAD_REQUEST, "Moderator gehört nicht der Lobby an");
	}

}
