package com.easypark.pim.services.user;

import com.easypark.pim.dtos.user.UserCreateDTO;
import com.easypark.pim.dtos.user.UserDTO;

public interface UserRegisterService {
    UserDTO register(UserCreateDTO data);
}
