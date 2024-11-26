package com.easypark.pim.services.user;

import com.easypark.pim.dtos.user.UserDTO;

import java.util.List;

public interface UserGetAllService {
    List<UserDTO> getAll();
}
