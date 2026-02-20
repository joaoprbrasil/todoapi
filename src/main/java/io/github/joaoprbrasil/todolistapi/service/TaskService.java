package io.github.joaoprbrasil.todolistapi.service;

import io.github.joaoprbrasil.todolistapi.model.TaskModel;
import io.github.joaoprbrasil.todolistapi.repository.TaskRepository;
import io.github.joaoprbrasil.todolistapi.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public TaskModel save(TaskModel taskModel, HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);

        LocalDateTime currentDate = LocalDateTime.now();
        if(currentDate.isAfter(taskModel.getStartAt())
                || currentDate.isAfter(taskModel.getEndAt())){
            throw new IllegalArgumentException("A data de início/término deve ser maior que a data atual.");
        }

        if(taskModel.getStartAt().isAfter(taskModel.getEndAt())){
            throw new IllegalArgumentException("A data de início deve ser menor do que a data de término.");
        }

        return this.repository.save(taskModel);
    }

    public List<TaskModel> list(HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        return this.repository.findByIdUser((UUID) idUser);
    }

    public TaskModel update(UUID id, TaskModel taskModel, HttpServletRequest request){

        var task = this.repository.findById(id).orElse(null);

        if(task == null){
            throw new IllegalArgumentException("Tarefa não encontrada.");
        }

        var idUser = request.getAttribute("idUser");

        if(!task.getIdUser().equals(idUser)){
            throw new IllegalArgumentException("Usuário não tem permissão para alterar essa tarefa.");
        }

        Utils.copyNonNullProperties(taskModel, task);

        return this.repository.save(task);
    }
















}
