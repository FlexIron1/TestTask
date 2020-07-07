package ru.aservice.prod.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Coordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String latitude;
    private String longitude;
}
