package de.amit.battlequest.user.service.team;

import de.amit.battlequest.user.exception.TeamNotFoundException;
import de.amit.battlequest.user.exception.UserNotFoundException;
import de.amit.battlequest.user.model.Team;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamUserService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    private TeamService teamService;

    public ResponseEntity<String> add(Team team, User user) {
        if(team == null) throw new TeamNotFoundException();
        if(user == null) throw new UserNotFoundException();
        teamService.getUsers(team).add(user);
        teamRepository.save(team);
        return new ResponseEntity<>("Spieler wurde hinzugefügt", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(Team team, User user) {
        if(team == null) throw new TeamNotFoundException();
        if(user == null) throw new UserNotFoundException();
        teamService.getUsers(team).remove(user);
        teamRepository.save(team);
        return new ResponseEntity<>("Spieler wurde entfernt", HttpStatus.OK);
    }
}
