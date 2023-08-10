package com.example.BIKE_RENTAL.dao.repositories;

import com.example.BIKE_RENTAL.dao.entities.PlanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlanTypeRepository extends JpaRepository<PlanType, Integer> {
    @Query(value = "select * from Bike_Rental.Plan_type where plan_type_id IN :ids", nativeQuery = true)
    List<PlanType> getPlanTypes(@Param("ids") List<Integer> planIds);
}
