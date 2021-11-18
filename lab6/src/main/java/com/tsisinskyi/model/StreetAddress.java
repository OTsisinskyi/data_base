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
@Table(name = "street_address", schema = "mydb")
public class StreetAddress {
    @Id
    @Column(name = "name")
    private String name;
}
