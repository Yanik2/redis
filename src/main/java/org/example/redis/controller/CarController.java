package org.example.redis.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.redis.dto.CarDto;
import org.example.redis.dto.UpdateCarDto;
import org.example.redis.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/cars/{id}")
    public CarDto getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PutMapping("/cars/{id}")
    public CarDto updateCar(@PathVariable Long id, @RequestBody UpdateCarDto updateCarDto) {
        return carService.updateCar(id, updateCarDto);
    }
}
