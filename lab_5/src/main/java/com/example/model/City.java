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
@Table(name = "city", schema = "mydb")
public class City {
    @Id
    @Column(name = "name")
    private String name;
}
