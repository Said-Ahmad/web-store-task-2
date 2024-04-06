package com.example.webstoretask2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "products", schema = "test")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_seq")
    @SequenceGenerator(
            name = "product_seq",
            sequenceName = "test.product_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;


}
