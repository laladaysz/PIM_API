package com.easypark.pim.services.user;

import com.easypark.pim.dtos.authentication.TokenJWTDTO;
import com.easypark.pim.dtos.user.UserAuthenticationDTO;

public interface UserLoginService {
    TokenJWTDTO login(UserAuthenticationDTO data);
}
