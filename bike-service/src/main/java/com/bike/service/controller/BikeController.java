package com.bike.service.controller;

import com.bike.service.entity.Bike;
import com.bike.service.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes")
public class BikeController {
  private BikeService bikeService;
  
  @Autowired
  public BikeController(BikeService bikeService) {
    this.bikeService = bikeService;
  }
  
  @GetMapping()
  public ResponseEntity<List<Bike>> getAllBikes(){
    List<Bike> bikes = bikeService.getAllBikes();
    if(bikes.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    
    return ResponseEntity.ok(bikes);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Bike> getBike(@PathVariable int id){
    Bike bike = bikeService.getBikeById(id);
    if(bike == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(bike);
  }
  
  @PostMapping()
  public ResponseEntity<Bike> saveBike(@RequestBody Bike bike) {
    Bike savedBike = bikeService.saveBike(bike);
    return ResponseEntity.ok(savedBike);
  }
  
  @GetMapping("/user/{id}")
  public ResponseEntity<List<Bike>> getBikesByOwner(@PathVariable Integer id){
    List<Bike> bikes = bikeService.getByOwner(id);
    if(bikes.isEmpty()){
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(bikes);
  }
  
}
