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
@Table(name = "parking_story", schema = "mydb")
public class ParkingStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "parking_id")
    private Integer parking_id;
    @Column(name = "user_card_id")
    private Integer user_card_id;
    @Column(name = "number_car")
    private String numberCar;
    @Column(name = "action")
    private String action;
    @Column(name = "timestamp")
    private String timestamp;
}
