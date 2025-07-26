package com.lucasmonteiro.shoppingapi.services;

import com.lucasmonteiro.shoppingapi.entities.Product;
import com.lucasmonteiro.shoppingapi.repositories.ProductRepository;
import com.lucasmonteiro.shoppingapi.services.exceptions.DatabaseException;
import com.lucasmonteiro.shoppingapi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insert(Product Product) {
        return repository.save(Product);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Product update(Long id, Product Product) {
        try {
            Product entity = repository.getReferenceById(id);
            updateData(entity, Product);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity, Product Product) {
        entity.setName(Product.getName());
        entity.setDescription(Product.getDescription());
        entity.setPrice(Product.getPrice());
        entity.setImgUrl(Product.getImgUrl());
    }
}
