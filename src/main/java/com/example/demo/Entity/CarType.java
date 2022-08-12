package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "car_type")
public class CarType {

    @Id
    @Column(name = "car_type_id")
    private Long id;

    @Column(name = "car_type")
    private String name;
}