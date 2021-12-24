package com.example.ordermanagement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ItemDto {
    private String itemName;
    private BigDecimal cost;
}
