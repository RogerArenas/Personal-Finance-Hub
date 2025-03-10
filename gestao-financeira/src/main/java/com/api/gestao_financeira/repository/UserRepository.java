package com.api.gestao_financeira.repository;

import com.api.gestao_financeira.model.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserSecurity, Long> {

    Optional<UserSecurity> findByUsername(String username);
}
