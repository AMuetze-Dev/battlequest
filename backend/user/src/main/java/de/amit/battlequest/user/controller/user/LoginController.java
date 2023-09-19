package de.amit.battlequest.user.controller.user;

import de.amit.battlequest.user.model.Credentials;
import de.amit.battlequest.user.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public UUID login(@RequestBody Credentials credentials) {
        return loginService.login(credentials);
    }
}
