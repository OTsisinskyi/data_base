package com.tsisinskyi.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Chain {
    private Integer id;
    private String name;

    public Chain(String name) {
        this(null, name);
    }
}
