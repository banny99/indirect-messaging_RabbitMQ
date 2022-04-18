package com.example.sdj3a02_indirectcommunication.service;

import com.example.sdj3a02_indirectcommunication.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderRabbitMQPublisher {

    private static final String EXCHANGE_NAME = "order_exchange";
    private static final String ROUTING_KEY = "order_routing_key";

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderRabbitMQPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public boolean sendOrderMessage(Order order) {
        try {
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, order);
            return true;
        }
        catch (Exception e){
            System.out.println("Error:" + e.getMessage());
            return false;
        }
    }


}

