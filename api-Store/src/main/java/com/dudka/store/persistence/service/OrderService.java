package com.dudka.store.persistence.service;

import com.dudka.store.persistence.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    Page<Order> findAll(Pageable pageable);
    List<Order> findAll();
    void saveOrder(Order order);
}
