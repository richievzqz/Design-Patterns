package com.designpatterns.app.strategy;

import com.designpatterns.app.strategy.implementations.StrategyBuy;
import com.designpatterns.app.strategy.implementations.StrategySell;
import com.designpatterns.app.strategy.interfaces.Strategy;
import com.designpatterns.app.strategy.model.Item;
import com.designpatterns.app.strategy.model.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Client {
    private static final HashMap<String, Item> stock = new HashMap<>();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static {
        stock.put("bike", new Item("bike", 100.00, 10));
        stock.put("helmet", new Item("helmet", 10.00, 50));
        stock.put("lock", new Item("lock", 20.00, 30));
        stock.put("light", new Item("light", 5.00, 50));
    }

        public static void main(String[] args) throws IOException {
            Order order = new Order();
            System.out.println("Buy or Sell?");
            String product = reader.readLine();
            if (product.equals("buy")) {
                order.setStrategy(new StrategyBuy());
                order.setProduct("buy");
            }
            if (product.equals("sell")) {
                order.setStrategy(new StrategySell());
                order.setProduct("sell");
            }
            order.createOrder(stock);
            System.out.println("Your Order");
            System.out.println(order);
            System.out.println("CURRENT STOCK = " + stock);
    }
}
