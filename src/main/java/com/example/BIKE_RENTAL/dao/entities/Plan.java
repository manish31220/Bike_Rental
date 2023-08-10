package com.example.BIKE_RENTAL.dao.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "Plan", catalog = "Bike_Rental")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long plan_id;


    public Long getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Long plan_id) {
        this.plan_id = plan_id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @Column(name = "rate")
    private double rate;

    @Column(name = "ModelId")
    private Integer modelId;

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    @Column(name = "plan_type_id")
    private Integer planType;
}
