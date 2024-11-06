package com.rgp.game.rpg.Domain.Auth;

import com.rgp.game.rpg.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrFindByEmail(String username, String email);
}
