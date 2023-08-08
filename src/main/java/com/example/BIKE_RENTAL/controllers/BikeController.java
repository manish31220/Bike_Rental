package com.example.BIKE_RENTAL.controllers;

import com.example.BIKE_RENTAL.dao.entities.Bike;
import com.example.BIKE_RENTAL.dao.entities.Inventory;
import com.example.BIKE_RENTAL.dao.entities.Plan;
import com.example.BIKE_RENTAL.dao.repositories.BikeRepository;
import com.example.BIKE_RENTAL.dao.repositories.InventoryRepository;
import com.example.BIKE_RENTAL.dao.repositories.PlanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bike")
public class BikeController {
    final Logger logger = LoggerFactory.getLogger(BikeController.class);

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private InventoryRepository inventoryRepository;


    @GetMapping("/model_options")
    public ResponseEntity<List<Bike>> viewBikeOptions() {
        List<Bike> bikeOptions = bikeRepository.findAll();

        Optional<List<Inventory>> availability = inventoryRepository.findAllByAvailability(1);
        if (availability.isEmpty()){
            return  null;
        }
        List<Inventory> availableBikes = availability.get();
        List<Bike> filteredBikeList = new ArrayList<>();

        for (Bike bike:bikeOptions) {
            for(Inventory inventory: availableBikes){
                if (inventory.getModelId() == bike.getModelId()){
                    filteredBikeList.add(bike);
                    break;
                }
            }
        }
        return ResponseEntity.ok(filteredBikeList);
    }
    @Autowired
    private PlanRepository planRepository;

    @GetMapping("/Plans")
    public ResponseEntity<List<Plan>> viewPlans(@RequestParam("modelid")int modelid) {
        Optional<List<Plan>> plans = planRepository.findByModelId(modelid);
        if(plans.isEmpty()){
            return null;
        }

        List<Plan> viewplans = plans.get();

       return ResponseEntity.ok(viewplans) ;
    }

    }
