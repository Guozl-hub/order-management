package com.example.ordermanagement.api;

import com.example.ordermanagement.application.OrderCreateService;
import com.example.ordermanagement.application.OrderQueryService;
import com.example.ordermanagement.dto.OrderItemsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderCreateService orderCreat;
    private final OrderQueryService orderQuery;

    @PostMapping
    public void creatOrder(@RequestBody OrderItemsDto request) {
        orderCreat.orderCreat(request);
    }

    @GetMapping("/{id}")
    public OrderItemsDto queryOrder(@PathVariable("id") Long id){
        return orderQuery.orderQuery(id);
    }

}
