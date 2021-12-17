package com.example.ordermanagement.infrastructure.jpa;

import com.example.ordermanagement.infrastructure.po.OrderItemsPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryJpa extends JpaRepository<OrderItemsPo,Long> {
}
