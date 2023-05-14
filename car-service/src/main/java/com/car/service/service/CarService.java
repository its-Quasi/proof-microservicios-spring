package com.car.service.service;

import com.car.service.entity.Car;
import com.car.service.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
  
  private CarRepository carRepository;
  //Dependency Injection
  @Autowired
  public CarService(CarRepository carRepository){
    this.carRepository = carRepository;
  }
  
  public List<Car> getAll(){
    return carRepository.findAll();
  }
  public Car getCarById(Integer id){
    return carRepository.findById(id).orElse(null);
  }
  public Car saveCar(Car car) {
    return carRepository.save(car);
  }
  
  public List<Car> getByOwner(Integer id){
    return carRepository.findByOwnerId(id);
  }
}
