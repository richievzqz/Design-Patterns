package com.designpatterns.app.strategy.model;

import com.designpatterns.app.strategy.interfaces.Strategy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
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
    private Strategy strategy;
    public Order() {
        this.orderId = new Random().nextInt();
    }
    public void createOrder(Map<String, Item> stock) throws IOException {
        strategy.executeOrder(stock, this);
    }
}
