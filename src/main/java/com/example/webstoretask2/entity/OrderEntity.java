package com.example.webstoretask2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "orders", schema = "test")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_seq")
    @SequenceGenerator(
            name = "order_seq",
            sequenceName = "test.orders_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "number_of_orders")
    private Integer numberOfOrder;
}
