package com.tsisinskyi.DTO;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParkingStoryDTO {
    private Integer id;
    private Integer parking_id;
    private Integer user_card_id;
    private String numberCar;
    private String action;
    private String timestamp;
}
