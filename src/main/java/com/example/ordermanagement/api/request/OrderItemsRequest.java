package com.example.ordermanagement.api.request;

import com.example.ordermanagement.matadata.OrderStatusType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderItemsRequest {
    private OrderStatusType orderStatusType;
    private List<ItemInfo> items;
}
