package com.user.service.controller;
import com.user.service.entity.User;
import com.user.service.model.Bike;
import com.user.service.model.Car;
import com.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  
  private UserService service;
  
  @Autowired
  public UserController(UserService service){
    this.service = service;
  }
  
  @GetMapping
  public ResponseEntity<List<User>> getUsers(){
    List<User> users = service.getAll();
    if(users.isEmpty()) return ResponseEntity.noContent().build();
    return ResponseEntity.ok(users);
  }
  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable Integer id){
    User user = service.getUserById(id);
    if(user != null) {
      return ResponseEntity.ok(user);
    }
    return ResponseEntity.notFound().build();
  }
  
  @PostMapping()
  public ResponseEntity<User> saveUser(@RequestBody User user){
    User savedUser = service.saveUser(user);
    return ResponseEntity.ok(savedUser);
  }
  
  @GetMapping("/cars/{id}")
  public ResponseEntity<List<Car>> getCars(@PathVariable Integer id){
    User user = service.getUserById(id);
    if(user == null) {
      return ResponseEntity.notFound().build();
    }
    var cars = service.getCarsUser(id);
    return ResponseEntity.ok(cars);
  }
  
  @GetMapping("/bikes/{id}")
  public ResponseEntity<List<Bike>> getBikes(@PathVariable Integer id){
    User user = service.getUserById(id);
    if(user == null) {
      return ResponseEntity.notFound().build();
    }
    var bikes = service.getBikesUser(id);
    return ResponseEntity.ok(bikes);
  }
  
  @PostMapping("/car/{id}")
  public ResponseEntity<Car> saveCar(@PathVariable Integer id, @RequestBody Car car){
    Car savedCar = service.saveCar(id, car);
    return ResponseEntity.ok(savedCar);
  }
  
}
