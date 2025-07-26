package com.lucasmonteiro.shoppingapi.repositories;

import com.lucasmonteiro.shoppingapi.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
