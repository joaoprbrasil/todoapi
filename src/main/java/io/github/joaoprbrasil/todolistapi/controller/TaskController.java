package io.github.joaoprbrasil.todolistapi.controller;

import io.github.joaoprbrasil.todolistapi.model.TaskModel;
import io.github.joaoprbrasil.todolistapi.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity save(@RequestBody TaskModel taskModel, HttpServletRequest request){
        return  service.save(taskModel, request);
    }

    @GetMapping
    public List<TaskModel> list(HttpServletRequest request){
        return service.list(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable UUID id,
                       @RequestBody TaskModel taskModel,
                       HttpServletRequest request){
        return service.update(id, taskModel, request);
    }











}
