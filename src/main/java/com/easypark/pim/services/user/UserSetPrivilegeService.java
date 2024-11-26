package com.easypark.pim.services.user;

import com.easypark.pim.dtos.user.UserRoleDTO;
import com.easypark.pim.dtos.user.UserDTO;

public interface UserSetPrivilegeService {
    UserDTO setPrivilege(Long id, UserRoleDTO data);
}
