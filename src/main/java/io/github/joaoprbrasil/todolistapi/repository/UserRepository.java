package io.github.joaoprbrasil.todolistapi.repository;

import io.github.joaoprbrasil.todolistapi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
