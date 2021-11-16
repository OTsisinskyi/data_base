package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@ToString
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_card", schema = "mydb")
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "enterprise_id")
    private Integer enterprise_id;
    @Column(name = "regular_user")
    private Boolean regularUser;

    public UserCard(String name, String surname, Long phone_number, Integer enterprise_id, Boolean regular_user) {
        this(null, name, surname, phone_number, enterprise_id, regular_user);
    }
}
