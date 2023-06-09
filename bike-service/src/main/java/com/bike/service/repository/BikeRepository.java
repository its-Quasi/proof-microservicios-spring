package com.bike.service.repository;

import com.bike.service.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike , Integer> {
  List<Bike> findByOwnerId(Integer id);
}
