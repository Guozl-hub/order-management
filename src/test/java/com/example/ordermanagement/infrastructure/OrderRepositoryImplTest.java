package com.example.ordermanagement.infrastructure;

import com.example.ordermanagement.domain.order.repository.OrderRepository;
import com.example.ordermanagement.dto.ItemDto;
import com.example.ordermanagement.dto.OrderItemsDto;
import com.example.ordermanagement.infrastructure.po.ItemPo;
import com.example.ordermanagement.infrastructure.po.OrderItemsPo;
import com.example.ordermanagement.matadata.OrderStatusType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

@ActiveProfiles("test")
@EnableJpaRepositories
@DataJpaTest
@EnableJpaAuditing
@Import(OrderRepositoryImpl.class)
class OrderRepositoryImplTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private OrderRepository orderRepository;

    OrderItemsDto ordersDto;
    List<ItemDto> itemsDto;
    OrderItemsPo orders;
    List<ItemPo> items;
    @BeforeEach
    void setUp(){
        items = List.of(ItemPo.builder()
                .name("ipone11")
                .cost(BigDecimal.valueOf(5999))
                .build(),
            ItemPo.builder()
                .name("huawei mate20")
                .cost(BigDecimal.valueOf(4999))
                .build());
        orders = OrderItemsPo.builder()
            .status(OrderStatusType.ARRIVED)
            .items(items).build();

        itemsDto = List.of(ItemDto.builder()
            .itemName("ipone11")
            .cost(BigDecimal.valueOf(5999))
            .build(), ItemDto.builder()
            .itemName("huawei mate20")
            .cost(BigDecimal.valueOf(4999))
            .build());
        ordersDto = OrderItemsDto.builder()
            .orderStatusType(OrderStatusType.ARRIVED)
            .items(itemsDto).build();
    }

    @Test
    void should_save_success_when_given_an_order() {
        //given

        //when
        OrderItemsDto orderItemsDto = orderRepository.orderCreat(ordersDto);

        OrderItemsPo orderItemsPo = testEntityManager.find(OrderItemsPo.class, orderItemsDto.getId());

        //then
        Assertions.assertEquals(orders.getStatus(), orderItemsPo.getStatus());

        for (int i = 0; i < 2; i++) {
            Assertions.assertEquals(items.get(i).getName(), orderItemsPo.getItems().get(i).getName());
            Assertions.assertEquals(items.get(i).getCost(), orderItemsPo.getItems().get(i).getCost());
        }
    }

    @Test
    void should_query_an_order_when_given_an_id(){
        //given

        //when
        testEntityManager.persist(orders);
        OrderItemsDto orderItemsDto = orderRepository.orderQuery(1L);
        //then
        Assertions.assertEquals(ordersDto.getOrderStatusType(),orderItemsDto.getOrderStatusType());
        for (int i = 0; i < 2; i++) {
            Assertions.assertEquals(ordersDto.getItems().get(i).getItemName(),orderItemsDto.getItems().get(i).getItemName());
            Assertions.assertEquals(ordersDto.getItems().get(i).getCost(),orderItemsDto.getItems().get(i).getCost());
        }
    }
}