package com.user.service.feignclients;

import com.user.service.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "car-service", url = "http://localhost:8002")
@RequestMapping("/cars")
public interface CarFeignClient {
  /** Esto minimo esta mal por el nombre del metodo , deberia llamarse igual que en el microservicio-carro:D*/
  
  @PostMapping
  Car save(@RequestBody Car car);
  
}
