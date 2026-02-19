package io.github.joaoprbrasil.todolistapi.controller;

import io.github.joaoprbrasil.todolistapi.model.TaskModel;
import io.github.joaoprbrasil.todolistapi.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity save(@RequestBody TaskModel taskModel, HttpServletRequest request){
        return  service.save(taskModel, request);
    }

}
