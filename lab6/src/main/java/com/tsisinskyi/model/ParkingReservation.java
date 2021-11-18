package com.tsisinskyi.model;

import lombok.*;

import javax.persistence.*;

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
}
