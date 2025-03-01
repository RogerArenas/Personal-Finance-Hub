package com.api.gestao_financeira.service;

import com.api.gestao_financeira.model.User;
import com.api.gestao_financeira.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UsuarioRepository usuarioRepository;

    public UserService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;

    }

    public List<User> listarUser () {
        return usuarioRepository.findAll();

    }

    public User salvarUser(User user) {
        return usuarioRepository.save(user);
    }
}
