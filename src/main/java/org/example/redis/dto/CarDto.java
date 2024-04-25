package org.example.redis.dto;

public record CarDto(
    Long id,
    String model,
    String brand,
    String ownerName
) {
}
