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
@Table(name = "city", schema = "mydb")
public class City {
    @Id
    @Column(name = "name")
    private String name;
}
