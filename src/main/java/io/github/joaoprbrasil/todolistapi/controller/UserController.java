package io.github.joaoprbrasil.todolistapi.controller;

import io.github.joaoprbrasil.todolistapi.model.UserModel;

import io.github.joaoprbrasil.todolistapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserModel> save(@RequestBody UserModel user){
        return service.save(user);
    }


}
