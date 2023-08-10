package com.example.BIKE_RENTAL.controllers;

import com.example.BIKE_RENTAL.dao.entities.*;
import com.example.BIKE_RENTAL.dao.repositories.BikeRepository;
import com.example.BIKE_RENTAL.dao.repositories.InventoryRepository;
import com.example.BIKE_RENTAL.dao.repositories.PlanRepository;
import com.example.BIKE_RENTAL.dao.repositories.PlanTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
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

    @Autowired
    private PlanTypeRepository planTypeRepository;

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
    public ResponseEntity<List<DisplayPlan>> viewPlans(@RequestParam("modelid")int modelid) {
        Optional<List<Plan>> plans = planRepository.findByModelId(modelid);
        if(plans.isEmpty()){
            return null;
        }

        List<Plan> viewplans = plans.get();
        List<Integer> distinctList = new ArrayList<>();
        for(Plan plan : viewplans){
            if (!distinctList.contains(plan.getPlanType())){
                distinctList.add(plan.getPlanType());
            }
        }

        List<PlanType> planTypeList = planTypeRepository.getPlanTypes(distinctList);

        List<DisplayPlan> displayPlans = getDisplayPlansFromPlans(viewplans, planTypeList);

        return ResponseEntity.ok(displayPlans);
    }

    private List<DisplayPlan> getDisplayPlansFromPlans(List<Plan> viewplans,
                                                       List<PlanType> planTypeList) {
        List<DisplayPlan> displayPlans = new ArrayList<>();
        for(Plan plan: viewplans){
            DisplayPlan displayPlan = new DisplayPlan();
            displayPlan.setPlan_id(plan.getPlan_id());
            displayPlan.setPlanType(plan.getPlanType());
            displayPlan.setRate(plan.getRate());
            displayPlan.setModelId(plan.getModelId());

            for(PlanType type: planTypeList){
                if (type.getPlanTypeId() == plan.getPlanType()){
                    displayPlan.setPlaName(type.getPlan_name());
                    break;
                }
            }

            displayPlans.add(displayPlan);
        }
        return displayPlans;
    }

    private String searchPlanName(int planTypeId) {
        switch (planTypeId) {
            case 1:
                return "hourly";
            case 2:
                return "daily";
            case 3:
                return "weekly";
            case 4:
                return "monthly";

        }
        return null;
    }


    }


