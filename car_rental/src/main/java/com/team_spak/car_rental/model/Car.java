package com.team_spak.car_rental.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "car" )
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String brand;
    private String model;
    private int year;
    private String color;
    private String engine;
    private String status;

}
