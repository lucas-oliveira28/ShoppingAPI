package com.lucasmonteiro.shoppingapi.repositories;

import com.lucasmonteiro.shoppingapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
