package br.com.gammonsistemas.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gammonsistemas.order_service.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}
