package com.user.service.model;

import lombok.Getter;
import lombok.Setter;

public class Bike {
  
  public Bike(){}
  
  @Getter @Setter
  private String brand;
  @Getter @Setter
  private String model;
  @Getter @Setter
  private Integer ownerId;
  
}
