package com.tsisinskyi.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class ParkingStory {
    private Integer id;
    private Integer parking_id;
    private Integer user_card_id;
    private String number_car;
    private String action;
    private String timestamp;

    public ParkingStory(Integer parking_id, Integer user_card_id, String number_car, String action, String timestamp) {
        this(null, parking_id, user_card_id, number_car, action, timestamp);
    }
}
