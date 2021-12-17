package com.example.ordermanagement.dto;

import com.example.ordermanagement.matadata.OrderStatusType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderItemsDto {
    private OrderStatusType orderStatusType;
    private List<ItemDto> items;
}
