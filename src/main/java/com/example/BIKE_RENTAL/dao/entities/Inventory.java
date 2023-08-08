package com.example.BIKE_RENTAL.dao.entities;

import jakarta.persistence.*;


@Entity
@Table(name="Inventory", catalog = "Bike_Rental")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bike_Id")
    private Long inventoryId;

    @Column(name = "availability")
    private Integer availability;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "Model_Id")
    private Integer modelId;

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
}
