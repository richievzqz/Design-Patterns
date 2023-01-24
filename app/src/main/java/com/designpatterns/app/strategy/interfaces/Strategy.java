package com.designpatterns.app.strategy.interfaces;

import com.designpatterns.app.strategy.model.Item;
import com.designpatterns.app.strategy.model.Order;

import java.io.IOException;
import java.util.Map;

public interface Strategy {
    void executeOrder(Map<String, Item> stock, Order order) throws IOException;

}
