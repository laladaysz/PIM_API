package com.easypark.pim.implementations.user;

import com.easypark.pim.dtos.user.UserCreateDTO;
import com.easypark.pim.dtos.user.UserDTO;
import com.easypark.pim.entities.User;
import com.easypark.pim.repositories.UserRepository;
import com.easypark.pim.services.user.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO register(UserCreateDTO data) {
        if(repository.findByLogin(data.login()) != null) {
            throw new IllegalArgumentException("Login já existente!");
        }

        User user = new User(data, passwordEncoder.encode(data.senha()));

        repository.save(user);

        return new UserDTO(user);
    }
}
