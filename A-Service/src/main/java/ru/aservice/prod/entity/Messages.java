package ru.aservice.prod.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String msg;
    private Date createdAt;
    private String language;
    private Double currentTemp;

    @OneToOne(cascade = CascadeType.ALL)
    private Coordinate coordinate;

}
