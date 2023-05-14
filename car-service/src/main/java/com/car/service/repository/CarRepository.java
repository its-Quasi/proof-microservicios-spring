package com.car.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.car.service.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
  List<Car> findByOwnerId(Integer id);
}
