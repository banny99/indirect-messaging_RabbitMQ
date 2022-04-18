package com.example.sdj3a02_indirectcommunication.service;

import com.example.sdj3a02_indirectcommunication.model.Order;

public interface IOrderService {

    public Order createOrder(Order order);

    public Order getOrder(Long orderId);

    public Order updateOrder(Order order);

    public Order deleteOrder(Long orderId);

}
