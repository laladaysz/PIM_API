package com.easypark.pim.dtos.user;

import com.easypark.pim.entities.User;

public record UserDTO(Long id, String nome, String login) {

    public UserDTO(User user) {
        this(user.getIdUsuario(), user.getNome(), user.getLogin());
    }
}