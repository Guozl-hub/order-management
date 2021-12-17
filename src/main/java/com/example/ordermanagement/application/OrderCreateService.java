package com.example.ordermanagement.application;

import com.example.ordermanagement.domain.order.repository.OrderRepository;
import com.example.ordermanagement.dto.OrderItemsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCreateService {
    private final OrderRepository orderRepository;

    public void orderCreat(OrderItemsDto orderItemsDto) {
        orderRepository.orderCreat(orderItemsDto);
    }
}
