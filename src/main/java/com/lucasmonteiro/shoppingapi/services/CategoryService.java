package com.lucasmonteiro.shoppingapi.services;

import com.lucasmonteiro.shoppingapi.entities.Category;
import com.lucasmonteiro.shoppingapi.repositories.CategoryRepository;
import com.lucasmonteiro.shoppingapi.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
