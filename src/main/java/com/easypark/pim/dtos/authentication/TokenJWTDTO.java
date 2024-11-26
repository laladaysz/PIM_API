package com.easypark.pim.dtos.authentication;

import java.time.Instant;

public record TokenJWTDTO(String token, String expiresAt) {
}
