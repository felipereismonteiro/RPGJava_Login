package com.rgp.game.rpg.Domain.Auth;


import com.rgp.game.rpg.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public String login(LoginDTO loginDTO) throws Exception {
        Optional<User> userFounded = authRepository.findByUsernameOrFindByEmail(loginDTO.username(), loginDTO.email());

        if (userFounded.isEmpty()) {
            throw new Exception("User not found");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(loginDTO.password(), userFounded.get().getPassword())) {
            throw new Exception("Invalid password");
        }

        // TODO gerar o TOKEN JWT
        return "Success";
    }
}
