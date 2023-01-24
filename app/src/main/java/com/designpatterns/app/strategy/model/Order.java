package com.designpatterns.app.strategy.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Getter
@Setter
@ToString
public class Order {
    private Integer orderId;
    private String product;
    private List<Item> items;

    public Order(String product) {
        this.orderId = new Random().nextInt();
        this.product = product;
    }

}
