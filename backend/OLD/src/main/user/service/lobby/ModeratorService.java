package service.lobby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import exception.HttpException;
import exception.LobbyNotFoundException;
import exception.ModeratorNotFoundException;
import model.Lobby;
import model.User;
import repository.LobbyRepository;

public class ModeratorService {

	@Autowired
	private LobbyRepository lobbyRepository;

	public ResponseEntity<String> create(Lobby lobby, User moderator) {
		ResponseEntity<String> responseEntity = update(lobby, moderator);
		if (responseEntity.getStatusCode() == HttpStatus.OK)
			responseEntity = new ResponseEntity<>("Moderator wurde gesetzt", HttpStatus.OK);
		return responseEntity;
	}

	public ResponseEntity<String> delete(Lobby lobby) {
		if (lobby.getModerator() == null)
			return new ResponseEntity<>("Diese Lobby hat keinen Moderator", HttpStatus.BAD_REQUEST);
		lobby.setModerator(null);
		lobbyRepository.save(lobby);
		return new ResponseEntity<>("Moderator wurde entfernt", HttpStatus.OK);
	}

	public User read(Lobby lobby) {
		if (lobby.getModerator() == null)
			throw new ModeratorNotFoundException();
		return lobby.getModerator();
	}

	public ResponseEntity<String> update(Lobby lobby, User moderator) {
		try {
			if (lobby == null)
				throw new LobbyNotFoundException();
			if (moderator == null)
				throw new ModeratorNotFoundException();
			if (!lobby.getCode().equals(moderator.getLobby().getCode()))
				throw new HttpException("Moderator gehört nicht der Lobby an", HttpStatus.BAD_REQUEST);
			if (lobby.getModerator() != null && lobby.getModerator().getUuid().equals(moderator.getUuid()))
				throw new HttpException("Ist bereits Moderator der Lobby", HttpStatus.BAD_REQUEST);
			lobby.setModerator(moderator);
			lobbyRepository.save(lobby);
			return new ResponseEntity<>("Moderator wurde ausgetauscht", HttpStatus.OK);
		} catch (final HttpException e) {
			return e.getResponseEntity();
		}
	}
}
