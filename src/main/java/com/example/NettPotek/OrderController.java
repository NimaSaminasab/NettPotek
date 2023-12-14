package com.example.NettPotek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    @ResponseBody
    public ResponseEntity createOrder(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
    }

    @GetMapping("/findAllOrders")
    public List<Order> findAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/findOrderById/{id}")
    public Order findOrderById(@PathVariable long id) {
        return orderService.findById(id);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable long id) {
        boolean deleted = orderService.deleteOrder(id);
        if (deleted)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
