package com.tsisinskyi.model;

import com.mysql.cj.protocol.x.XProtocolRow;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class Parking {
    private Integer id;
    private Integer total_number;
    private Integer price_per_hour;
    private String street_address_name;
    private String district_name;
    private String city_name;
    private Integer chain_id;

    public Parking(Integer total_number, Integer price_per_hour, String street_address_name, String district_name, String city_name, Integer chain_id) {
        this(null, total_number, price_per_hour, street_address_name, district_name, city_name, chain_id);
    }
}
