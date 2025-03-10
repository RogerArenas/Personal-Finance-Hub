package com.api.gestao_financeira.service;

import com.api.gestao_financeira.model.User;
import com.api.gestao_financeira.model.UserSecurity;
import com.api.gestao_financeira.repository.UserRepository;
import com.api.gestao_financeira.security.Enuns.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public void registerUser(String username, String password, String name, String mail) {

        UserSecurity userSecurity = new UserSecurity();
        userSecurity.setUsername(username);
        userSecurity.setPassword(passwordEncoder.encode(password));
        userSecurity.setRole(UserRole.ROLE_USER);
        userRepository.save(userSecurity);

        User user = new User();
        user.setName(name);
        user.setName(mail);
        user.setPassword(password);
        userService.salvarUser(user);

    }

    public Optional<UserSecurity> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
