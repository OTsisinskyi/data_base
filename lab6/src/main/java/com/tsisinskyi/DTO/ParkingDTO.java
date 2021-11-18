package com.tsisinskyi.DTO;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDTO {
    private Integer id;
    private Integer totalNumber;
    private Integer pricePerHour;
    private String streetAddress;
    private String district;
    private String city;
    private Integer chain;
}
