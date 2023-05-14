package com.bike.service.service;

import com.bike.service.entity.Bike;
import com.bike.service.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {
  private BikeRepository bikeRepository;
  
  @Autowired
  public BikeService(BikeRepository bikeRepository) {
    this.bikeRepository = bikeRepository;
  }
  
  public List<Bike> getAllBikes(){
    return bikeRepository.findAll();
  }
  public Bike getBikeById(Integer id){
    return bikeRepository.findById(id).orElse(null);
  }
  public Bike saveBike(Bike bike) {
    return bikeRepository.save(bike);
  }
  
  public List<Bike> getByOwner(Integer id){
    return bikeRepository.findByOwnerId(id);
  }
  
}
