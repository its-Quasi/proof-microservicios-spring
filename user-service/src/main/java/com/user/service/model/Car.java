package com.user.service.model;

import lombok.Getter;
import lombok.Setter;

public class Car {
  public Car(){}
  
  @Getter @Setter
  private String brand;
  @Getter @Setter
  private String model;
  @Getter @Setter
  private Integer ownerId;
}
