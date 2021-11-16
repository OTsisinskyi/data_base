package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@ToString
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parking_reservation", schema = "mydb")
public class ParkingReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "car_number")
    private String carNumber;
    @Column(name = "time")
    private String time;
    @Column(name = "parking_id")
    private Integer parking_id;

    public ParkingReservation(String car_number, String time, Integer parking_id) {
        this(null, car_number, time, parking_id);
    }
}
