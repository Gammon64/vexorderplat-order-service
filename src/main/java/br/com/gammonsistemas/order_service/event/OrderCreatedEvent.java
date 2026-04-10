package br.com.gammonsistemas.order_service.event;

import java.time.LocalDateTime;

public record OrderCreatedEvent(String orderId, String customerId, Double total, LocalDateTime createdAt) {
}
