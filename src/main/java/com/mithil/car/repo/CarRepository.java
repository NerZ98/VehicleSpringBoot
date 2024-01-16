package com.mithil.car.repo;

import com.mithil.car.entities.car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository <car, Integer>{
}
