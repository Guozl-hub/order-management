package com.example.ordermanagement.infrastructure;

import com.example.ordermanagement.domain.order.repository.OrderRepository;
import com.example.ordermanagement.dto.OrderItemsDto;
import com.example.ordermanagement.infrastructure.jpa.OrderRepositoryJpa;
import com.example.ordermanagement.infrastructure.po.ItemPo;
import com.example.ordermanagement.infrastructure.po.OrderItemsPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private final OrderRepositoryJpa orderRepositoryJpa;

    @Override
    public void orderCreat(OrderItemsDto orderItemsDto) {
        List<ItemPo> itemPoList = orderItemsDto.getItems().stream()
            .map(item -> ItemPo.builder().name(item.getItemName()).cost(item.getCost()).build())
            .collect(Collectors.toList());
        OrderItemsPo orderItemsPo = OrderItemsPo.builder()
            .status(orderItemsDto.getOrderStatusType())
            .items(itemPoList).build();
        orderRepositoryJpa.save(orderItemsPo);
    }

    @Override
    public void orderQuery(OrderItemsDto orderItemsDto) {

    }
}
