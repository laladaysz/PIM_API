package com.easypark.pim.implementations.user;

import com.easypark.pim.dtos.user.UserRoleDTO;
import com.easypark.pim.dtos.user.UserDTO;
import com.easypark.pim.entities.User;
import com.easypark.pim.repositories.UserRepository;
import com.easypark.pim.services.user.UserSetPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSetPrivilegeServiceImpl implements UserSetPrivilegeService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO setPrivilege(Long id, UserRoleDTO data) {
        User user = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));
        user.setRole(data.role());

        return new UserDTO(user);
    }
}
