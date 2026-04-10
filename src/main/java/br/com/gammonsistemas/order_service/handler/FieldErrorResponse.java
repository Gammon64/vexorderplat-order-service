package br.com.gammonsistemas.order_service.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldErrorResponse {

    private String field;
    private String message;
}
