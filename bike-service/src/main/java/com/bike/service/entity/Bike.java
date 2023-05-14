package com.bike.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bike {
  
  public Bike(){
  
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Integer id;
  @Getter @Setter
  private String brand;
  @Getter @Setter
  private String model;
  @Getter @Setter
  private Integer ownerId;

  
}
