package com.example.demo.Repository;


import com.example.demo.Entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarTypeRepository extends JpaRepository<CarType, Long> {
}