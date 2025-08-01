package com.lucasmonteiro.shoppingapi.services;

import com.lucasmonteiro.shoppingapi.entities.User;
import com.lucasmonteiro.shoppingapi.repositories.UserRepository;
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
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
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

    public User update(Long id, User user) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, user);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
    }

    public void login(Long id, String password) {
        try {
            User entity = repository.getReferenceById(id);
            if (entity.getPassword().equals(password)) {
                entity.setLogin(true);
                repository.save(entity);
            }
        }  catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
