package com.example.webstoretask2.controller;

import com.example.webstoretask2.domain.Order;
import com.example.webstoretask2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.saveOrder(order));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(orderService.getById(id));

    }
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getOrderById() {
        return ResponseEntity.ok(orderService.getAllOrders());

    }
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteOrder(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(orderService.deleteOrder(id));

    }
    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.updateOrder(order));

    }

}
