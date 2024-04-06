package com.example.webstoretask2.repository;

import com.example.webstoretask2.domain.Order;
import com.example.webstoretask2.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    Optional<OrderEntity> findByNumberOfOrder(Integer integer);

    List<OrderEntity> findAllByNumberOfOrderIn(List<Integer> integers);
}
