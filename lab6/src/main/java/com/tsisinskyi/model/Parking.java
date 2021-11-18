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
@Table(name = "parking", schema = "mydb")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "total_number")
    private Integer totalNumber;
    @Column(name = "price_per_hour")
    private Integer pricePerHour;
    @Column(name = "street_address_name")
    private String streetAddress;
    @Column(name = "district_name")
    private String district;
    @Column(name = "city_name")
    private String city;
    @Column(name = "chain_id")
    private Integer chain;
}
