package com.designpatterns.app.strategy.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Item {
    private String name;
    private Double price;
    private Integer amount;
}
