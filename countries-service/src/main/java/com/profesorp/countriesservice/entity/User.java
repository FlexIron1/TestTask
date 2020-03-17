package com.profesorp.countriesservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "usertable")
public class User  {
    @Id
    @GeneratedValue
    Long id;
    String lastName;
    String firstName;
}
