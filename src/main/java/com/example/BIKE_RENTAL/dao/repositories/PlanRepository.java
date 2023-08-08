package com.example.BIKE_RENTAL.dao.repositories;

import com.example.BIKE_RENTAL.dao.entities.Plan;
import com.example.BIKE_RENTAL.dao.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface PlanRepository extends JpaRepository<Plan,Integer> {
    Optional<List<Plan>> findByModelId(int modelId);
}

