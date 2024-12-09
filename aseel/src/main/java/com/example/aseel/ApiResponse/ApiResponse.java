package com.example.aseel.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ApiResponse {
    private String message;
    public ApiResponse(String message) {
        this.message = message;
    }
}
