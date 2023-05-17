package com.user.service.service;

import com.user.service.entity.User;
import com.user.service.feignclients.CarFeignClient;
import com.user.service.model.Bike;
import com.user.service.model.Car;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  
  private String URL_MICROSERVICE_CAR = "http://localhost:8002/cars/user/";
  private String URL_MICROSERVICE_BIKE = "http://localhost:8003/bikes/user/";
  private UserRepository userRepository;
  
  @Autowired
  private CarFeignClient carFeignClient;
  
  @Autowired
  private RestTemplate restTemplate;
  
  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }
  
  public List<Car> getCarsUser(Integer id){
    List<Car> cars = restTemplate.getForObject(URL_MICROSERVICE_CAR + id , List.class);
    return cars;
  }
  
  public List<Bike> getBikesUser(Integer id){
    List<Bike> bikes = restTemplate.getForObject(URL_MICROSERVICE_BIKE + id , List.class);
    return bikes;
  }
  
  public List<User> getAll(){
    return userRepository.findAll();
  }
  
  public User getUserById(Integer id){
    Optional<User> userOptional = userRepository.findById(id);
    return userOptional.orElse(null);
  }
  
  public User saveUser(User user){
    User savedUser = userRepository.save(user);
    return savedUser;
  }
  
  public Car saveCar(Integer ownerId, Car car){
    car.setOwnerId(ownerId);
    Car savedCar = carFeignClient.save(car);
    return savedCar;
  }
  
  
}
