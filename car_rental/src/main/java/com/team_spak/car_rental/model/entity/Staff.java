package com.team_spak.car_rental.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "personnel")

public class Staff {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String lastname;
    private int age;
    private int experience;

}
