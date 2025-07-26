package com.lucasmonteiro.shoppingapi.repositories;

import com.lucasmonteiro.shoppingapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
