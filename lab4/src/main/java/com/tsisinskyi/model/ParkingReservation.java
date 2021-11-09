package com.tsisinskyi.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class ParkingReservation {
    private Integer id;
    private String car_number;
    private String time;
    private Integer parking_id;

    public ParkingReservation(String car_number, String time, Integer parking_id) {
        this(null, car_number, time, parking_id);
    }
}