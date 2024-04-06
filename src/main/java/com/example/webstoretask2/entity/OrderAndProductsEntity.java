package com.example.webstoretask2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "order_and_products", schema = "test")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderAndProductsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_and_products_seq")
    @SequenceGenerator(
            name = "order_and_products_seq",
            sequenceName = "test.order_and_products_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_id")
    private Integer productId;
}
