package com.example.production_ready_features.advice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

  private LocalDateTime timestamp;
  private  T data;
  private ApiError error;

    public ApiResponse() {
        this.timestamp=LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(T data, ApiError error) {
        this();
        this.data = data;
        this.error = error;
    }
}
