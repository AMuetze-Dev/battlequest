package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Lobby;

public interface LobbyRepository extends JpaRepository<Lobby, String> {

}
