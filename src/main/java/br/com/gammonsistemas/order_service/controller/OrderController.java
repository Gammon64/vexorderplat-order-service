package br.com.gammonsistemas.order_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gammonsistemas.order_service.dto.OrderRequest;
import br.com.gammonsistemas.order_service.entity.Order;
import br.com.gammonsistemas.order_service.service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Order> create(@Valid @RequestBody OrderRequest request) {
        return ResponseEntity.ok(service.createOrder(request));
    }
}
