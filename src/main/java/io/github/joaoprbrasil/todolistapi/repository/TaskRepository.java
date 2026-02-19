package io.github.joaoprbrasil.todolistapi.repository;

import io.github.joaoprbrasil.todolistapi.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskModel, UUID> {
    List<TaskModel> findByIdUser(UUID idUser);

    UUID id(UUID id);
}
