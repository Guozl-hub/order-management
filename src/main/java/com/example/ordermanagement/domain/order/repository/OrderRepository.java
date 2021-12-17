package com.example.ordermanagement.domain.order.repository;

import com.example.ordermanagement.dto.OrderItemsDto;

public interface OrderRepository {
    public void orderCreat(OrderItemsDto orderItemsDto);
    public void orderQuery(OrderItemsDto orderItemsDto);
}
