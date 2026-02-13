package io.github.joaoprbrasil.todolistapi.controller;

import io.github.joaoprbrasil.todolistapi.model.UserModel;
import io.github.joaoprbrasil.todolistapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserRepository repository;

    @PostMapping
    public void save(@RequestBody UserModel user){
        repository.save(user);
    }

}
