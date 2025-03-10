package com.api.gestao_financeira.security.Enuns;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String username;
    private String password;
    private String name;
    private String mail;
}
