package com.example.ordermanagement.domain.order.repository;

import com.example.ordermanagement.dto.OrderItemsDto;

public interface OrderRepository {
    OrderItemsDto orderCreat(OrderItemsDto orderItemsDto);

    OrderItemsDto orderQuery(Long id);
}
