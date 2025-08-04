package com.lucasmonteiro.shoppingapi.services;

import com.lucasmonteiro.shoppingapi.entities.User;
import com.lucasmonteiro.shoppingapi.entities.dto.LoginRequest;
import com.lucasmonteiro.shoppingapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> login(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                user.setLogin(true);
                userRepository.save(user);
                return ResponseEntity.ok("Login bem sucedido");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha invalido");
    }

}
