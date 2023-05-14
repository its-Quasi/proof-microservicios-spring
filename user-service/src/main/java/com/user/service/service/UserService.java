package com.user.service.service;

import com.user.service.entity.User;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  private UserRepository userRepository;
  
  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
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
}
