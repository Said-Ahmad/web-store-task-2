package com.example.webstoretask2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product_and_racks", schema = "test")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductAndRacksEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_and_racks_seq")
    @SequenceGenerator(
            name = "product_and_racks_seq",
            sequenceName = "test.product_and_racks_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "racks_id")
    private Integer rackId;

    @Column(name = "is_primary")
    private Boolean isPrimary;


}
