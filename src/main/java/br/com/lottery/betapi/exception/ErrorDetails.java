package br.com.lottery.betapi.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    
}
