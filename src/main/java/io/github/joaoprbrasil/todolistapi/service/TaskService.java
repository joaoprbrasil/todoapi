package io.github.joaoprbrasil.todolistapi.service;

import io.github.joaoprbrasil.todolistapi.model.TaskModel;
import io.github.joaoprbrasil.todolistapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public void save(TaskModel taskModel){
        repository.save(taskModel);
    }

}
