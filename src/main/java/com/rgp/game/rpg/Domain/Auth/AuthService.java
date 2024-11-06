package com.rgp.game.rpg.Domain.Auth;


import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public String login(LoginDTO loginDTO) {
        // TODO regras de negocio
//        Usuário precisa existir no banco
//        Email precisa existir no banco
//        Senha precisa esta correta, comparando com bcrypt

        return "login";
    }
}
