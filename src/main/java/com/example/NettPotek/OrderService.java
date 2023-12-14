package com.example.NettPotek;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        order.setTotal(order.calculateTotal());
        return orderRepository.save(order);
    }

    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Order findById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }
}
