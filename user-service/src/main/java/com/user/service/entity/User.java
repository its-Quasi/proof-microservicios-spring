package com.user.service.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Integer id;
  @Getter @Setter
  private String name;
  @Getter @Setter
  private String email;
  
}
