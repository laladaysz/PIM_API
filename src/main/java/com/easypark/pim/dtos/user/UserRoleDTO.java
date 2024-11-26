package com.easypark.pim.dtos.user;

import com.easypark.pim.entities.enums.UserRole;
import jakarta.validation.constraints.NotBlank;

public record UserRoleDTO(@NotBlank UserRole role) {
}
