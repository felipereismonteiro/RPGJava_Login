package com.rgp.game.rpg.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LoginDTO(
    @NotBlank(message = "Username or Email is required")
    @Size(max = 100, message = "Username or Email can have up to 100 characters")
    @Pattern(
        regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$|^[A-Za-z0-9._%+-]{1,100}$",
        message = "Invalid format for Username or Email"
    )
    String usernameOrEmail,

    @NotBlank(message = "Password is required")
    @Size(min = 4, message = "Password must be at least 8 characters long")
    String password
) {
}