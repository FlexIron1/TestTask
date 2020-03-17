package com.profesorp.capitalsservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "usertable")
public class User implements Serializable{
    @Id
    @GeneratedValue
    Long id;
    String lastName;
    String firstName;
}
