package com.api.gestao_financeira.controller;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
