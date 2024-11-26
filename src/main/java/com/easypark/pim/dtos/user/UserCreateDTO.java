package com.easypark.pim.dtos.user;

import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(@NotBlank String nome, @NotBlank String login, @NotBlank String senha) {
}