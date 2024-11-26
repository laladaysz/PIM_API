package com.easypark.pim.services.authentication;

import com.easypark.pim.entities.User;

public interface TokenGenerateService {
    String gerarToken(User user);
}
