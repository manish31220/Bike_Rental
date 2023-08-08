package com.example.BIKE_RENTAL.dao.repositories;

import com.example.BIKE_RENTAL.dao.entities.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, Integer> {

}
