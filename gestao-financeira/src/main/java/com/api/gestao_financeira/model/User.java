package com.api.gestao_financeira.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Entity
@Table(name = "usuarios")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = true, length = 100)
    private String mail;

    @Column(nullable = false)
    private String password;
}
