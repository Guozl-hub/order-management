package com.example.ordermanagement.infrastructure.po;

import com.example.ordermanagement.matadata.OrderStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class OrderItemsPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatusType status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private List<ItemPo> items;

    public OrderItemsPo(OrderStatusType status, List<ItemPo> items) {
        this.status = status;
        this.items = items;
    }
}
