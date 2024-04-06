package com.example.webstoretask2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "racks", schema = "test")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RackEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rack_seq")
    @SequenceGenerator(
            name = "rack_seq",
            sequenceName = "test.racks_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "name")
    private String name;

}
