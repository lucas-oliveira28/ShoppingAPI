package com.lucasmonteiro.shoppingapi.repositories;

import com.lucasmonteiro.shoppingapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
