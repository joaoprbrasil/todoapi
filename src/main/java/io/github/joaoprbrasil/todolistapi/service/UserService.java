package io.github.joaoprbrasil.todolistapi.service;

import io.github.joaoprbrasil.todolistapi.model.UserModel;
import io.github.joaoprbrasil.todolistapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserModel save(UserModel userModel){
        var username = userModel.getUsername();

        if(repository.existsByUsername(username)){
            throw new IllegalArgumentException("O username já existe.");
        }

        return repository.save(userModel);
    }
}
