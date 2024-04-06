package com.example.webstoretask2.repository;

import com.example.webstoretask2.entity.ProductAndRacksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductAndRacksRepository extends JpaRepository<ProductAndRacksEntity, Integer> {
    List<ProductAndRacksEntity> findAllByProductIdIn(Set<Integer> productIds);


    List<ProductAndRacksEntity> findAllByProductId(Integer id);
}
