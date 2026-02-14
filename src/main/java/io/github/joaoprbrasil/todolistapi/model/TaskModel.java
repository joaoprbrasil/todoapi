package io.github.joaoprbrasil.todolistapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID idUser;
    private String description;
    private String title;
    private LocalDateTime endDate;
    private LocalDateTime startDate;
    private String priority;

}
