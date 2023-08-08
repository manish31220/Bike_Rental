package com.example.BIKE_RENTAL.dao.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Bike", catalog = "Bike_Rental")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Model_id")
    private Integer modelId;

    @Column(name = "model_name")
    private String modelName;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
