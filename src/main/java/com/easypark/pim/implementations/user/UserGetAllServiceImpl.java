package com.easypark.pim.implementations.user;

import com.easypark.pim.dtos.user.UserDTO;
import com.easypark.pim.repositories.UserRepository;
import com.easypark.pim.services.user.UserGetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGetAllServiceImpl implements UserGetAllService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<UserDTO> getAll() {
        return repository.findAll().stream().map(UserDTO::new).toList();
    }
}
