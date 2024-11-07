package com.rgp.game.rpg.Domain.Auth;


import com.rgp.game.rpg.Config.JWTConfiguration;
import com.rgp.game.rpg.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private JWTConfiguration jwtConfiguration;

    public String login(LoginDTO loginDTO) throws Exception {
        Optional<User> userFounded = authRepository.findByUsernameOrEmail(loginDTO.usernameOrEmail());

        if (userFounded.isEmpty()) {
            throw new Exception("User not found");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(loginDTO.password(), userFounded.get().getPassword())) {
            throw new Exception("Invalid password");
        }

        return jwtConfiguration.generateToken(loginDTO.usernameOrEmail());
    }
}
