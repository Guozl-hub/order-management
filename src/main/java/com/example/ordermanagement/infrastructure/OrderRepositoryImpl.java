package com.example.ordermanagement.infrastructure;

import com.example.ordermanagement.domain.order.repository.OrderRepository;
import com.example.ordermanagement.dto.ItemDto;
import com.example.ordermanagement.dto.OrderItemsDto;
import com.example.ordermanagement.exception.CanNotFoundOrderException;
import com.example.ordermanagement.infrastructure.jpa.OrderRepositoryJpa;
import com.example.ordermanagement.infrastructure.po.ItemPo;
import com.example.ordermanagement.infrastructure.po.OrderItemsPo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderRepositoryJpa orderRepositoryJpa;

    @Override
    public OrderItemsDto orderCreat(OrderItemsDto orderItemsDto) {
        OrderItemsPo orderItemsPo = getOrderItemsPo(orderItemsDto);
        OrderItemsPo itemsPo = orderRepositoryJpa.save(orderItemsPo);
        return getOrderItemsDto(itemsPo);
    }

    @Override
    public OrderItemsDto orderQuery(Long id) {
        OrderItemsPo orderItemsPo = orderRepositoryJpa.findById(id).orElseThrow(() -> new CanNotFoundOrderException("order id is not exist"));
        return getOrderItemsDto(orderItemsPo);
    }

    private OrderItemsPo getOrderItemsPo(OrderItemsDto orderItemsDto) {
        List<ItemPo> itemPoList = orderItemsDto.getItems().stream()
            .map(item -> ItemPo.builder().name(item.getItemName()).cost(item.getCost()).build())
            .collect(Collectors.toList());
        return OrderItemsPo.builder()
            .status(orderItemsDto.getOrderStatusType())
            .items(itemPoList).build();
    }

    private OrderItemsDto getOrderItemsDto(OrderItemsPo orderItemsPo) {
        List<ItemDto> itemDtoList = orderItemsPo.getItems().stream()
            .map(item -> ItemDto.builder().itemName(item.getName()).cost(item.getCost()).build())
            .collect(Collectors.toList());
        return OrderItemsDto.builder()
            .id(orderItemsPo.getId())
            .orderStatusType(orderItemsPo.getStatus())
            .items(itemDtoList).build();
    }


}
