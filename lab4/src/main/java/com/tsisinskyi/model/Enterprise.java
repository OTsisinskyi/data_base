package com.tsisinskyi.model;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class Enterprise {
    private Integer id;
    private String name;

    public Enterprise(String name) {
        this(null, name);
    }
}