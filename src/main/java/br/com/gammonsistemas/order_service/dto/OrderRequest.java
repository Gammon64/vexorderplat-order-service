package br.com.gammonsistemas.order_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(@NotBlank String customerId, @NotNull Double total) {
}