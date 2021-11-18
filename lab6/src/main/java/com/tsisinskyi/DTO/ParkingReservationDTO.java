package com.tsisinskyi.DTO;

import lombok.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParkingReservationDTO {
    private Integer id;
    private String carNumber;
    private String time;
    private Integer parking_id;
}
