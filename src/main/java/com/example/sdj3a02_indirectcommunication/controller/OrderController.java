package com.example.sdj3a02_indirectcommunication.controller;

import com.example.sdj3a02_indirectcommunication.model.Order;
import com.example.sdj3a02_indirectcommunication.service.IOrderService;
import com.example.sdj3a02_indirectcommunication.service.OrderRabbitMQPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private IOrderService orderService;
    private OrderRabbitMQPublisher orderPublisher;

    @Autowired
    public OrderController(IOrderService orderService, OrderRabbitMQPublisher orderPublisher) {
        this.orderService = orderService;
        this.orderPublisher = orderPublisher;
    }

    @GetMapping()
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping()
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        //publish
        if (orderPublisher.sendOrderMessage(order)){
            System.out.println("order published successfully");
        }
        else {
            System.out.println("order failed to publish");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }

    @PutMapping("/{id}")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }
}

