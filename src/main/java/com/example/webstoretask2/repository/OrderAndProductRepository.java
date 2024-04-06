package com.example.webstoretask2.repository;

import com.example.webstoretask2.entity.OrderAndProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderAndProductRepository extends JpaRepository<OrderAndProductsEntity,Integer> {

        List<OrderAndProductsEntity> findAllByOrderId(Integer orderId);
}
