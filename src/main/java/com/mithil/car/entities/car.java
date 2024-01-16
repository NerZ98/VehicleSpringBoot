package com.mithil.car.entities;

import jakarta.persistence.*;

@Entity

public class car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="name")
    String name;
    @Column(name="brand")
    String brand;
    @Column(name="door")
    int door;
    @Column(name="powertrain")
    String powertrain;
    @Column(name="type")
    String type;
    @Column(name="hp")
    int hp;
    @Column(name="mileage")
    int mileage;
    @Column(name="price")
    int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public String getPowertrain() {
        return powertrain;
    }

    public void setPowertrain(String powertrain) {
        this.powertrain = powertrain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
