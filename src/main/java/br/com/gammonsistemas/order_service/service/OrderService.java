package br.com.gammonsistemas.order_service.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gammonsistemas.order_service.dto.OrderRequest;
import br.com.gammonsistemas.order_service.entity.Order;
import br.com.gammonsistemas.order_service.event.OrderCreatedEvent;
import br.com.gammonsistemas.order_service.repository.OrderRepository;

@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository repository;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderService(OrderRepository repository,
            KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public Order createOrder(OrderRequest request) {

        Order order = new Order();
        order.setCustomerId(request.customerId());
        order.setTotal(request.total());
        order.setCreatedAt(LocalDateTime.now());

        Order saved = repository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(
                saved.getId(),
                saved.getCustomerId(),
                saved.getTotal(),
                saved.getCreatedAt());

        kafkaTemplate.send("order.created", saved.getId(), event);

        return saved;
    }
}
