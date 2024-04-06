package com.example.webstoretask2.repository;

import com.example.webstoretask2.entity.RackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepository extends JpaRepository<RackEntity,Integer> {

}
