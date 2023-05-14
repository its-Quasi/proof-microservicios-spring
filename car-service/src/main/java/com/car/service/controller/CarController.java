package com.car.service.controller;

import com.car.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.car.service.entity.Car;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
  private CarService carService;
  
  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;
  }
  
  @GetMapping
  public ResponseEntity<List<Car>> getCars(){
    List<Car> cars = carService.getAll();
    if(cars.isEmpty()){
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(cars);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Car> getCar(@PathVariable Integer id){
    Car car = carService.getCarById(id);
    if(car != null) {
      return ResponseEntity.ok(car);
    }
    return ResponseEntity.notFound().build();
  }
  
  @PostMapping()
  public ResponseEntity<Car> saveCar(@RequestBody Car car){
    Car savedCar = carService.saveCar(car);
    return ResponseEntity.ok(savedCar);
  }
  
  @GetMapping("/user/{id}")
  public ResponseEntity<List<Car>> getCarsByOwner(@PathVariable Integer id){
    List<Car> cars = carService.getByOwner(id);
    if(cars.isEmpty()){
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(cars);
  }
}
