package com.rgp.game.rpg.Domain.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/auth")
public class Auth {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody @Validated LoginDTO loginDTO) {
        try {
            return authService.login(loginDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
