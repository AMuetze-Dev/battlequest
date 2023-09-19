package de.amit.battlequest.user.service.team;

import de.amit.battlequest.user.exception.TeamNotFoundException;
import de.amit.battlequest.user.exception.UserNotFoundException;
import de.amit.battlequest.user.model.Lobby;
import de.amit.battlequest.user.model.Team;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public ResponseEntity<String> create() {
        Team team = new Team();
        teamRepository.save(team);
        return new ResponseEntity<>("Team wurde angelegt", HttpStatus.CREATED);
    }

    public Team read(UUID uuid) {
        return teamRepository.findById(uuid).orElseThrow(TeamNotFoundException::new);
    }

    public ResponseEntity<String> updateLeader(Team team, User user) {
        if(team == null ) throw new TeamNotFoundException();
        if(user == null) throw new UserNotFoundException();
        if(!user.getTeam().getUuid().equals(team.getUuid())) return new ResponseEntity<>("Spieler gehört dem Team nicht an", HttpStatus.BAD_REQUEST);
        team.setLeader(user);
        teamRepository.save(team);
        return new ResponseEntity<>("Teamleiter wurde geändert", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteLeader(Team team) {
        if(team == null) throw new TeamNotFoundException();
        if(team.getLeader()== null) return new ResponseEntity<>("Das Team hat keinen Teamleiter", HttpStatus.BAD_REQUEST);
        team.setLeader(null);
        teamRepository.save(team);
        return new ResponseEntity<>("Teamleiter wurde entfernt", HttpStatus.OK);
    }

    public ResponseEntity<String> updateTeamname(Team team, String teamname) {
        if(team == null) throw new TeamNotFoundException();
        team.setTeamname(teamname);
        teamRepository.save(team);
        return new ResponseEntity<>("Teamname wurde geändert", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(Team team) {
        if(team == null) throw new TeamNotFoundException();
        teamRepository.delete(team);
        return new ResponseEntity<>("Team wurde entfernt", HttpStatus.OK);
    }

    public User getLeader(Team team) {
        if(team == null) throw new TeamNotFoundException();
        return team.getLeader();
    }

    public List<User> getUsers(Team team) {
        if(team == null) throw new TeamNotFoundException();
        return team.getUsers();
    }

    public String getTeamname(Team team) {
        if(team == null) throw new TeamNotFoundException();
        return team.getTeamname();
    }

    public Lobby getLobby(Team team) {
        if(team == null) throw new TeamNotFoundException();
        return team.getLobby();
    }
}
