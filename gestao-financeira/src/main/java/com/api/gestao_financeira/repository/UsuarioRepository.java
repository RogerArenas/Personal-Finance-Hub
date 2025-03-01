package com.api.gestao_financeira.repository;

import com.api.gestao_financeira.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<User, UUID> {
    Optional<User> findByMail(String mail);
}