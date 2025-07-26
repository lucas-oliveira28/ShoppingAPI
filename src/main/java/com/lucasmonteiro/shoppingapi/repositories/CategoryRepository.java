package com.lucasmonteiro.shoppingapi.repositories;

import com.lucasmonteiro.shoppingapi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
