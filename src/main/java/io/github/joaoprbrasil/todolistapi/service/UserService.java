package io.github.joaoprbrasil.todolistapi.service;

import io.github.joaoprbrasil.todolistapi.model.UserModel;
import io.github.joaoprbrasil.todolistapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity save(UserModel userModel){
        var username = userModel.getUsername();

        if(repository.existsByUsername(username)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        var passwordHashred = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(passwordHashred);

        var newUser = repository.save(userModel);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(newUser);
    }





}
