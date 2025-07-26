package com.lucasmonteiro.shoppingapi.config;

import com.lucasmonteiro.shoppingapi.entities.User;
import com.lucasmonteiro.shoppingapi.entities.enums.UserLevel;
import com.lucasmonteiro.shoppingapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Lucas Monteiro", "lucas.monteiro@gmail.com", "12345", UserLevel.ADMIN);
        User u2 = new User(null, "João Silva", "joao.silva@gmail.com", "12345", UserLevel.EMPLOYEE);
        User u3 = new User(null, "Augusto Renan", "augusto.renan@gmail.com", "12345", UserLevel.CLIENT);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
