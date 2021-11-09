package com.tsisinskyi.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserCard {
    private Integer id;
    private String name;
    private String surname;
    private Long phone_number;
    private Integer enterprise_id;
    private Boolean regular_user;

    public UserCard(String name, String surname, Long phone_number, Integer enterprise_id, Boolean regular_user) {
        this(null, name, surname, phone_number, enterprise_id, regular_user);
    }
}

