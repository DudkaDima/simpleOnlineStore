package com.dudka.store.persistence.service.implementation;

import com.dudka.store.persistence.entity.Order;
import com.dudka.store.persistence.repository.OrderRepository;
import com.dudka.store.persistence.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
