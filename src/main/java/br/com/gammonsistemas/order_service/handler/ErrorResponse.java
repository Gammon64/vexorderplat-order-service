package br.com.gammonsistemas.order_service.handler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {

    private String message;
    private int status;
    private LocalDateTime timestamp;
    private List<FieldErrorResponse> errors;

}
