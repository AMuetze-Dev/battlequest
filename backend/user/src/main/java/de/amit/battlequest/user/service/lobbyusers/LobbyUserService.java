package de.amit.battlequest.user.service.lobbyusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.amit.battlequest.user.repository.LobbyUsersRepository;

@Service
public class LobbyUserService {

	@Autowired
	LobbyUsersRepository usersLobbyRepository;
}
