package com.example.ordermanagement.api;

import com.example.ordermanagement.api.request.OrderItemsRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-management")
public class OrderController {
    @PostMapping("/creation")
    @ResponseBody
    public OrderItemsRequest creatOrder(@RequestBody OrderItemsRequest request){
        return request;
    }
}
