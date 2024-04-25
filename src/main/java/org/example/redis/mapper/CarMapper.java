package org.example.redis.mapper;

import org.example.redis.dto.CarDto;
import org.example.redis.model.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto toDto(CarEntity car) {
        return new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getOwner().getName());
    }
}
