package com.example.BIKE_RENTAL.dao.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "Plan", catalog = "Bike_Rental")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long plan_id;

    @Column(name = "plan_name")
    private String plan_name;

    public Long getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Long plan_id) {
        this.plan_id = plan_id;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
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

    @Column(name = "rate_id")
    private double rate;

    @Column(name = "Model_id")
    private Integer modelId;
}
