package com.team_spak.car_rental.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Category {
@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private  long id ;

private  String  name  ;
private String description ;










}
