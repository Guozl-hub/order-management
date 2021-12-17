package com.example.ordermanagement.api;

import com.example.ordermanagement.application.OrderCreateService;
import com.example.ordermanagement.dto.OrderItemsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderCreateService orderCreat;

    @PostMapping
    @ResponseBody
    public void creatOrder(@RequestBody OrderItemsDto request) {
        orderCreat.orderCreat(request);
    }
}
