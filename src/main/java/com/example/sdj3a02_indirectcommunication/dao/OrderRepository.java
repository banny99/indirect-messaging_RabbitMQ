package com.example.sdj3a02_indirectcommunication.dao;

import com.example.sdj3a02_indirectcommunication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
