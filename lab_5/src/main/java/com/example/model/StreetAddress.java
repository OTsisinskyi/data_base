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
@Table(name = "street_address", schema = "mydb")
public class StreetAddress {
    @Id
    @Column(name = "name")
    private String name;
}
