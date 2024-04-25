package org.example.redis.service;

import lombok.RequiredArgsConstructor;
import org.example.redis.CarRepository;
import org.example.redis.dto.CarDto;
import org.example.redis.dto.UpdateCarDto;
import org.example.redis.mapper.CarMapper;
import org.example.redis.model.CarEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {
    private final RedisCacheService redisCacheService;
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarDto getCarById(Long id) {
        var car = redisCacheService.getValue("cachedCar");

        if (car == null) {
            car = carRepository.findById(id).orElseThrow();
            redisCacheService.cacheValue(car);
        }

        final var carDto = carMapper.toDto(car);
        return carDto;
    }

    public CarDto updateCar(Long id, UpdateCarDto updateCarDto) {
        final var car = carRepository.findById(id).orElseThrow();

        car.setBrand(updateCarDto.brand());
        car.setModel(updateCarDto.model());
        carRepository.save(car);
        redisCacheService.evictValue("cachedCar");
        return carMapper.toDto(car);
    }
}

