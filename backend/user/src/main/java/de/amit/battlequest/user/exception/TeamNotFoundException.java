package de.amit.battlequest.user.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class TeamNotFoundException extends HttpException{

    @Serial
    private static final long serialVersionUID = 1;
    public TeamNotFoundException() {
        super("Team wurde nicht gefunden", HttpStatus.NOT_FOUND);
    }
}
