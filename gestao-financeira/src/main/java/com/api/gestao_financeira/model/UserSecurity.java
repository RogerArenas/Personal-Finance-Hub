package com.api.gestao_financeira.model;

import com.api.gestao_financeira.security.Enuns.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios_security")
@Data
public class UserSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

}
