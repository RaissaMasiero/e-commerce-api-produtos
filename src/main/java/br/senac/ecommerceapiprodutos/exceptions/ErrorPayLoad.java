package br.senac.ecommerceapiprodutos.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ErrorPayLoad {

    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
