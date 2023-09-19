package de.amit.battlequest.user.service.team;

import de.amit.battlequest.user.model.Team;
import de.amit.battlequest.user.model.User;
import de.amit.battlequest.user.service.lobbyusers.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamPointService {

    @Autowired
    private PointService pointService;

    public ResponseEntity<String> increase(Team team) {
        return increase(team, 1);
    }

    public ResponseEntity<String> increase(Team team, int delta) {
        ResponseEntity<String> response = new ResponseEntity<>("Punkte wurden nicht verändert", HttpStatus.NOT_MODIFIED);
        for (User user : team.getUsers()) {
            response = pointService.increase(team.getLobby(), user, delta);
            if (response.getStatusCode() != HttpStatus.OK)
                break;
        }
        return response;
    }

    public ResponseEntity<String> decrease(Team team) {
        return decrease(team, 1);
    }

    public ResponseEntity<String> decrease(Team team, int delta) {
        ResponseEntity<String> response = new ResponseEntity<>("Punkte wurden nicht verändert", HttpStatus.NOT_MODIFIED);
        for (User user : team.getUsers()) {
            response = pointService.decrease(team.getLobby(), user, delta);
            if (response.getStatusCode() != HttpStatus.OK)
                break;
        }
        return response;
    }
}
