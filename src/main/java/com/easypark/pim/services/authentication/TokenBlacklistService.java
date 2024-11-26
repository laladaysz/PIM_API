package com.easypark.pim.services.authentication;

import java.util.Set;

public interface TokenBlacklistService {
    void blacklistToken(String token);
    boolean isTokenBlacklisted(String token);
}
