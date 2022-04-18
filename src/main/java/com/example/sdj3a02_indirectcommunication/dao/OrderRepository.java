package com.example.sdj3a02_indirectcommunication.dao;

import com.example.sdj3a02_indirectcommunication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.description = ?1")
    Optional<Order> findByDescription(String description);
}
