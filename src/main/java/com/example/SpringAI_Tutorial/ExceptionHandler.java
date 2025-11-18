package com.example.SpringAI_Tutorial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionHandler {
    private LocalDateTime localDateTime;
    private String message;
    private String details;
}
