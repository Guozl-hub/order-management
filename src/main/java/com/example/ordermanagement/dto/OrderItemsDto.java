package com.example.ordermanagement.dto;

import com.example.ordermanagement.matadata.OrderStatusType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
@Builder
public class OrderItemsDto {
    @Enumerated(EnumType.STRING)
    private OrderStatusType orderStatusType;
    private List<ItemDto> items;
}
