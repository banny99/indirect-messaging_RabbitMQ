package com.example.sdj3a02_indirectcommunication.service;

import com.example.sdj3a02_indirectcommunication.dao.OrderRepository;
import com.example.sdj3a02_indirectcommunication.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }


    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order updatedOrder) {
//        return orderRepository.update(updatedOrder);
        Order orderToDelete = orderRepository.findById(updatedOrder.getId()).orElse(null);
        if (orderToDelete != null) {
            orderRepository.delete(orderToDelete);
            return orderRepository.save(updatedOrder);
        }
        return null;
    }

    @Override
    public Order deleteOrder(Long orderId) {
        Order orderToDelete = orderRepository.findById(orderId).orElse(null);
        if (orderToDelete != null) {
            orderRepository.delete(orderToDelete);
        }
        return orderToDelete;
    }

}
