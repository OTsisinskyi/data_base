package com.tsisinskyi.DTO;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserCardDTO {
    private Integer id;
    private String name;
    private String surname;
    private Long phoneNumber;
    private Integer enterprise_id;
    private Boolean regularUser;
}
