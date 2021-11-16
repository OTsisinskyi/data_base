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
@Table(name = "enterprise", schema = "mydb")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    public Enterprise(String name) {
        this(null, name);
    }
}
